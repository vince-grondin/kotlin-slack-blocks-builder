package eth.rochsolid.slack.blocks.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.net.URL

sealed interface CompositionObject {
    /**
     * Defines a dialog that adds a confirmation step to interactive elements.
     * An object that defines a dialog that provides a confirmation step to any interactive element.
     * This dialog will ask the user to confirm their action by offering a confirm and deny buttons.
     * [View API docs](https://api.slack.com/reference/block-kit/composition-objects#confirm)
     *
     * [Example](https://api.slack.com/reference/block-kit/composition-objects#confirm__example)([view this in Block Kit Builder](https://api.slack.com/tools/block-kit-builder?mode=message&blocks=%5B%7B%22type%22%3A%22section%22%2C%22text%22%3A%7B%22type%22%3A%22mrkdwn%22%2C%22text%22%3A%22You%20have%20a%20new%20request%3A%5Cn*%3CfakeLink.toEmployeeProfile.com%7CFred%20Enriquez%20-%20New%20device%20request%3E*%22%7D%7D%2C%7B%22type%22%3A%22section%22%2C%22fields%22%3A%5B%7B%22type%22%3A%22mrkdwn%22%2C%22text%22%3A%22*Type%3A*%5CnComputer%20(laptop)%22%7D%2C%7B%22type%22%3A%22mrkdwn%22%2C%22text%22%3A%22*When%3A*%5CnSubmitted%20Aut%2010%22%7D%2C%7B%22type%22%3A%22mrkdwn%22%2C%22text%22%3A%22*Last%20Update%3A*%5CnMar%2010%2C%202015%20(3%20years%2C%205%20months)%22%7D%2C%7B%22type%22%3A%22mrkdwn%22%2C%22text%22%3A%22*Reason%3A*%5CnAll%20vowel%20keys%20aren%27t%20working.%22%7D%2C%7B%22type%22%3A%22mrkdwn%22%2C%22text%22%3A%22*Specs%3A*%5Cn%5C%22Cheetah%20Pro%2015%5C%22%20-%20Fast%2C%20really%20fast%5C%22%22%7D%5D%7D%2C%7B%22type%22%3A%22actions%22%2C%22elements%22%3A%5B%7B%22type%22%3A%22button%22%2C%22text%22%3A%7B%22type%22%3A%22plain_text%22%2C%22emoji%22%3Atrue%2C%22text%22%3A%22Approve%22%7D%2C%22confirm%22%3A%7B%22title%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22Are%20you%20sure%3F%22%7D%2C%22text%22%3A%7B%22type%22%3A%22mrkdwn%22%2C%22text%22%3A%22Wouldn%27t%20you%20prefer%20a%20good%20game%20of%20_chess_%3F%22%7D%2C%22confirm%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22Do%20it%22%7D%2C%22deny%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22Stop%2C%20I%27ve%20changed%20my%20mind!%22%7D%7D%2C%22style%22%3A%22primary%22%2C%22value%22%3A%22click_me_123%22%7D%2C%7B%22type%22%3A%22button%22%2C%22text%22%3A%7B%22type%22%3A%22plain_text%22%2C%22emoji%22%3Atrue%2C%22text%22%3A%22Deny%22%7D%2C%22style%22%3A%22danger%22%2C%22value%22%3A%22click_me_123%22%7D%5D%7D%5D))
     * ```json
     * {
     *     "title": {
     *         "type": "plain_text",
     *         "text": "Are you sure?"
     *     },
     *     "text": {
     *         "type": "plain_text",
     *         "text": "Wouldn't you prefer a good game of chess?"
     *     },
     *     "confirm": {
     *         "type": "plain_text",
     *         "text": "Do it"
     *     },
     *     "deny": {
     *         "type": "plain_text",
     *         "text": "Stop, I've changed my mind!"
     *     }
     * }
     * ```
     */
    data class ConfirmationDialog(
        /**
         * A [CompositionObject.Text.PlainText] object that defines the dialog's title.
         * Maximum length for this field is 100 characters.
         */
        val title: Text.PlainText,
        /**
         * A [Text.PlainText] object that defines the explanatory text that appears in the confirm
         * dialog.
         * Maximum length for the text in this field is 300 characters.
         */
        val text: Text.PlainText,
        /**
         * A [Text.PlainText] object to define the text of the button that confirms the action.
         * Maximum length for the text in this field is 30 characters.
         */
        val confirm: Text.PlainText,
        /**
         * A [Text.PlainText] object to define the text of the button that cancels the action.
         * Maximum length for the text in this field is 30 characters.
         */
        val deny: Text.PlainText,
        /**
         * Defines the color scheme applied to the [confirm] button.
         * If this field is not provided, the default value will be [Style.PRIMARY].
         */
        val style: Style?
    ) {
        enum class Style {
            /**
             * A value of danger will display the button with a red background on desktop, or red text on mobile.
             */
            @SerialName("danger")
            DANGER,

            /**
             * A value of primary will display the button with a green background on desktop, or blue text on mobile.
             */
            @SerialName("primary")
            PRIMARY
        }
    }

    data class InputParameter(
        val name: String,
        val value: String
    )

    /**
     * Defines a single item in a number of item selection elements.
     *
     * An object that represents a single selectable item in an [Element.Select] select menu,
     * an [Element.MultiSelect] multi-select menu, an [Element.Checkboxes] checkbox group,
     * an [Element.RadioButtons] radio button group, or an [Element.Overflow] overflow menu.
     *
     * Example ([view in the Block Kit Builder](https://api.slack.com/tools/block-kit-builder?mode=message&blocks=%5B%7B%22type%22%3A%22section%22%2C%22text%22%3A%7B%22type%22%3A%22mrkdwn%22%2C%22text%22%3A%22%3Amag%3A%20Search%20results%20for%20*Cata*%22%7D%7D%2C%7B%22type%22%3A%22divider%22%7D%2C%7B%22type%22%3A%22section%22%2C%22text%22%3A%7B%22type%22%3A%22mrkdwn%22%2C%22text%22%3A%22*%3CfakeLink.toYourApp.com%7CUse%20Case%20Catalogue%3E*%5CnUse%20Case%20Catalogue%20for%20the%20following%20departments%2Froles...%22%7D%2C%22accessory%22%3A%7B%22type%22%3A%22static_select%22%2C%22placeholder%22%3A%7B%22type%22%3A%22plain_text%22%2C%22emoji%22%3Atrue%2C%22text%22%3A%22Manage%22%7D%2C%22options%22%3A%5B%7B%22text%22%3A%7B%22type%22%3A%22plain_text%22%2C%22emoji%22%3Atrue%2C%22text%22%3A%22Edit%20it%22%7D%2C%22value%22%3A%22value-0%22%7D%2C%7B%22text%22%3A%7B%22type%22%3A%22plain_text%22%2C%22emoji%22%3Atrue%2C%22text%22%3A%22Read%20it%22%7D%2C%22value%22%3A%22value-1%22%7D%2C%7B%22text%22%3A%7B%22type%22%3A%22plain_text%22%2C%22emoji%22%3Atrue%2C%22text%22%3A%22Save%20it%22%7D%2C%22value%22%3A%22value-2%22%7D%5D%7D%7D%5D)):
     * ```json
     * {
     *     "text": {
     *         "type": "plain_text",
     *         "text": "Maru"
     *     },
     *     "value": "maru"
     * }
     * ```
     */
    data class Option(
        /**
         * A [Text.PlainText] text object that defines a line of descriptive text shown below the `text` field beside a
         * single selectable item in a [Element.Select] select menu,
         * an [Element.MultiSelect] multi-select menu, an [Element.Checkboxes] checkbox group,
         * an [Element.RadioButtons] radio button group, or an [Element.Overflow] overflow menu.
         * Maximum length for the `text` within this field is 75 characters.
         */
        val description: Text.PlainText?,
        /**
         * A [Text] object that defines the text shown in the option on the menu.
         * Overflow, select, and multi-select menus can only use [Text.PlainText] objects,
         * while radio buttons and checkboxes can use [Text.Markdown] text objects.
         * Maximum length for the text in this field is 75 characters.
         */
        val text: Text,
        /**
         * A unique string value that will be passed to your app when this option is chosen.
         * Maximum length for this field is 75 characters.
         */
        val value: String,
        /**
         * A URL to load in the user's browser when the option is clicked.
         * **The url attribute is only available in [Element.Overflow]overflow menus.**
         * Maximum length for this field is 3000 characters.
         * If you're using url, you'll still receive an
         * [interaction payload](https://api.slack.com/interactivity/handling#payloads)
         * and will need to
         * [send an acknowledgement response](https://api.slack.com/interactivity/handling#acknowledgment_response).
         */
        val url: URL
    )

    /**
     * Defines a way to group options in a menu.
     *
     * The menu can be a [select menu](https://api.slack.com/reference/block-kit/block-elements#select)
     * or a [multi-select menu](https://api.slack.com/reference/block-kit/block-elements#multi_select).
     * An [OptionGroup] array can have a maximum number of 100 option groups with a maximum of 100 options.
     *
     * Example ([view in Block Kit Builder](https://api.slack.com/tools/block-kit-builder?mode=message&blocks=%5B%7B%22type%22%3A%22section%22%2C%22text%22%3A%7B%22type%22%3A%22mrkdwn%22%2C%22text%22%3A%22%3Amag%3A%20Search%20results%20for%20*Cata*%22%7D%7D%2C%7B%22type%22%3A%22divider%22%7D%2C%7B%22type%22%3A%22section%22%2C%22text%22%3A%7B%22type%22%3A%22mrkdwn%22%2C%22text%22%3A%22*%3CfakeLink.toYourApp.com%7CUse%20Case%20Catalogue%3E*%5CnUse%20Case%20Catalogue%20for%20the%20following%20departments%2Froles...%22%7D%2C%22accessory%22%3A%7B%22type%22%3A%22static_select%22%2C%22placeholder%22%3A%7B%22type%22%3A%22plain_text%22%2C%22emoji%22%3Atrue%2C%22text%22%3A%22Manage%22%7D%2C%22option_groups%22%3A%5B%7B%22label%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22Group%201%22%7D%2C%22options%22%3A%5B%7B%22text%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22*this%20is%20plain_text%20text*%22%7D%2C%22value%22%3A%22value-0%22%7D%2C%7B%22text%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22*this%20is%20plain_text%20text*%22%7D%2C%22value%22%3A%22value-1%22%7D%2C%7B%22text%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22*this%20is%20plain_text%20text*%22%7D%2C%22value%22%3A%22value-2%22%7D%5D%7D%2C%7B%22label%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22Group%202%22%7D%2C%22options%22%3A%5B%7B%22text%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22*this%20is%20plain_text%20text*%22%7D%2C%22value%22%3A%22value-3%22%7D%5D%7D%5D%7D%7D%5D)):
     * ```json
     * "option_groups": [
     *     {
     *         "label": {
     *             "type": "plain_text",
     *             "text": "Group 1"
     *         },
     *         "options": [
     *             {
     *                 "text": {
     *                     "type": "plain_text",
     *                     "text": "*this is plain_text text*"
     *                 },
     *                 "value": "value-0"
     *             },
     *             {
     *                 "text": {
     *                     "type": "plain_text",
     *                     "text": "*this is plain_text text*"
     *                 },
     *                 "value": "value-1"
     *             },
     *             {
     *                 "text": {
     *                     "type": "plain_text",
     *                     "text": "*this is plain_text text*"
     *                 },
     *                 "value": "value-2"
     *             }
     *         ]
     *     },
     *     {
     *         "label": {
     *             "type": "plain_text",
     *             "text": "Group 2"
     *         },
     *         "options": [
     *             {
     *                 "text": {
     *                     "type": "plain_text",
     *                     "text": "*this is plain_text text*"
     *                 },
     *                 "value": "value-3"
     *             }
     *         ]
     *     }
     * ]
     * ```
     */
    data class OptionGroup(
        /**
         * A [Text.PlainText] text object that defines the label shown above this group of options.
         * Maximum length for the `text` in this field is 75 characters.
         */
        val label: Text.PlainText,
        /**
         * A list of [Option] objects that belong to this specific group.
         * Maximum of 100 items.
         */
        val options: List<Option>
    )

    /**
     * Defines an object containing Slack file information to be used in an image block or image element.
     *
     * This [file](https://api.slack.com/types/file) must be an image, and you must provide either the URL or ID.
     * In addition, the user posting these blocks must have access to this file.
     * If both are provided then the payload will be rejected.
     * Currently only `png`, `jpg`, `jpeg`, and `gif` Slack image files are supported.
     */
    sealed interface SlackFile {
        /**
         * Example:
         * ```json
         * {
         *   "slack_file": {
         *       "id": "F0123456",
         *   }
         * }
         * ```
         */
        data class IdSlackFile(
            /**
             * Slack ID of the file.
             */
            val id: ID
        ) : SlackFile {
            @JvmInline
            @Serializable
            value class ID(val value: String)
        }

        /**
         * Example:
         * ```json
         * {
         *   "slack_file": {
         *       "url": "https://files.slack.com/files-pri/T0123456-F0123456/xyz.png",
         *   }
         * }

         * ```
         */
        data class UrlSlackFile(
            /**
             * This URL can be the `url_private` or the `permalink` of the Slack file.
             */
            val url: URL
        ) : SlackFile
    }

    /**
     * Defines an object containing some text.
     * Formatted either as [TextType.PLAIN_TEXT]
     * or using [TextType.MARKDOWN] (see [Surfaces > Formatting](https://api.slack.com/reference/surfaces/formatting)),
     * Slack's proprietary contribution to the much beloved Markdown standard.
     *
     * Example ([view in the Block Kit Builder](https://api.slack.com/tools/block-kit-builder?mode=message&blocks=%5B%7B%22type%22%3A%22section%22%2C%22text%22%3A%7B%22type%22%3A%22mrkdwn%22%2C%22text%22%3A%22A%20message%20*with%20some%20bold%20text*%20and%20_some%20italicized%20text_.%22%7D%7D%5D)):
     * ```json
     * {
     *     "type": "mrkdwn",
     *     "text": "A message *with some bold text* and _some italicized text_."
     * }
     * ```
     */
    sealed class Text(
        /**
         * The formatting to use for this text object.
         */
        val type: TextType
    ) {
        enum class TextType {
            @SerialName("plain_text")
            PLAIN_TEXT,

            @SerialName("mrkdwn")
            MARKDOWN
        }

        data class Markdown(
            /**
             * The text for the block.
             * This field accepts any of the standard text formatting markup.
             * The minimum length is 1 and maximum length is 3000 characters.
             */
            val text: String,
            /**
             * When set to `false` (as is default) URLs will be auto-converted into links,
             * conversation names will be link-ified, and certain mentions will be
             * [automatically parsed](https://api.slack.com/reference/surfaces/formatting#automatic-parsing).
             * When set to `true`, Slack will continue to process all Markdown formatting and
             * [manual parsing strings](https://api.slack.com/reference/surfaces/formatting#advanced),
             * but it won’t modify any plain-text content. For example, channel names will not be hyperlinked.
             */
            val verbatim: Boolean? = false
        ) : Text(type = TextType.MARKDOWN)

        data class PlainText(
            val emoji: Boolean?,
            /**
             * The text for the block.
             * The minimum length is 1 and maximum length is 3000 characters.
             */
            val text: String,
        ) : Text(type = TextType.PLAIN_TEXT)
    }

    /**
     * Defines an object containing trigger information.
     *
     * Example:
     * ```json
     * {
     *   "url": "https://slack.com/shortcuts/Ft0123ABC456/123...xyz",
     *   "customizable_input_parameters": [
     *     {
     *       "name": "input_parameter_a",
     *       "value": "Value for input param A"
     *     },
     *     {
     *       "name": "input_parameter_b",
     *       "value": "Value for input param B"
     *     }
     *   ]
     * }
     * ```
     */
    data class Trigger(
        /**
         * An array of [InputParameter] input parameter objects.
         * Each specified name must match an input parameter defined on the workflow of the provided trigger (url),
         * and the input parameter mapping on the trigger must be set as `customizable: true`.
         * Each specified value must match the type defined by the workflow input parameter of the matching name.
         * **The values used for these [customizableInputParameters] may be visible client-side to end users.
         * You should not share sensitive information or secrets via these input parameters.**
         */
        @SerialName("customizable_input_parameters")
        val customizableInputParameters: List<InputParameter>?,
        /**
         * A [link trigger URL](https://api.slack.com/automation/triggers/link).
         * Must be associated with a valid trigger.
         */
        val url: URL
    )

    /**
     * Defines an object containing workflow information.
     *
     * Example:
     * ```json
     * {
     *   "trigger": {
     *       "url": "https://slack.com/shortcuts/Ft0123ABC456/321...zyx",
     *       "customizable_input_parameters": [
     *         {
     *           "name": "input_parameter_a",
     *           "value": "Value for input param A"
     *         },
     *         {
     *           "name": "input_parameter_b",
     *           "value": "Value for input param B"
     *         }
     *       ]
     *   }
     * }
     * ```
     */
    data class Workflow(
        /**
         * A [Trigger] trigger object that contains information about a workflow's trigger.
         */
        val trigger: Trigger
    )
}
