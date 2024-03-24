package eth.rochsolid.slack.blocks.models.compositionobjects

import java.net.URL


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
