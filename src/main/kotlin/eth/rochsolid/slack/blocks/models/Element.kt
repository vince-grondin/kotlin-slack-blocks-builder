package eth.rochsolid.slack.blocks.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.net.URL

/**
 * Block elements can be added to certain [app surfaces](https://api.slack.com/surfaces)
 * and used within certain [Block] types.
 *
 * Interactive components are block elements that add interactivity.
 * All block elements are interactive components except for one: the static image element.
 * The [handling user interactivity guide](https://api.slack.com/interactivity/handling) will help you prepare your app
 * to use interactive components.
 *
 * https://api.slack.com/reference/block-kit/block-elements
 */
sealed class Element(
    /**
     * The type of element.
     */
    val type: Type
) {
    enum class Type {
        @SerialName("button")
        BUTTON,

        @SerialName("checkboxes")
        CHECKBOX,

        @SerialName("datepicker")
        DATEPICKER,

        @SerialName("datetimepicker")
        DATETIMEPICKER,

        @SerialName("email_text_input")
        EMAIL_TEXT_INPUT,

        @SerialName("file_input")
        FILE_INPUT,

        @SerialName("image")
        IMAGE,

        @SerialName("multi_static_select")
        MULTI_STATIC_SELECT,

        @SerialName("multi_external_select")
        MULTI_EXTERNAL_SELECT,

        @SerialName("multi_users_select")
        MULTI_USERS_SELECT,

        @SerialName("multi_conversations_select")
        MULTI_CONVERSATIONS_SELECT,

        @SerialName("multi_channels_select")
        MULTI_CHANNELS_SELECT,

        @SerialName("number_input")
        NUMBER_INPUT,

        @SerialName("overflow")
        OVERFLOW,

        @SerialName("plain_text_input")
        PLAIN_TEXT_INPUT,

        @SerialName("radio_buttons")
        RADIO_BUTTONS,

        @SerialName("rich_text_input")
        RICH_TEXT_INPUT,

        @SerialName("static_select")
        STATIC_SELECT,

        @SerialName("external_select")
        EXTERNAL_SELECT,

        @SerialName("users_select")
        USERS_SELECT,

        @SerialName("conversations_select")
        CONVERSATIONS_SELECT,

        @SerialName("channels_select")
        CHANNELS_SELECT,

        @SerialName("timepicker")
        TIMEPICKER,

        @SerialName("url_text_input")
        URL_TEXT_INPUT,

        @SerialName("workflow_button")
        WORKFLOW_BUTTON,
    }

    /**
     * An action identifier.
     */
    @JvmInline
    @Serializable
    value class ActionID(val value: String)

    /**
     * Allows users a direct path to performing basic actions.
     * Interactive component - see the [guide to enabling interactivity](https://api.slack.com/interactivity/handling).
     *
     * Examples:
     * - A regular interactive button:
     * ```json
     * {
     *   "type": "button",
     *   "text": {
     *     "type": "plain_text",
     *     "text": "Click Me"
     *   },
     *   "value": "click_me_123",
     *   "action_id": "button"
     * }
     * ```
     * - A button with a primary style attribute:
     * ```json
     * {
     *   "type": "button",
     *   "text": {
     *     "type": "plain_text",
     *     "text": "Save"
     *   },
     *   "style": "primary",
     *   "value": "click_me_123",
     *   "action_id": "button"
     * }
     * ```
     * - A link button:
     * ```json
     * {
     *   "type": "button",
     *   "text": {
     *     "type": "plain_text",
     *     "text": "Link Button"
     *   },
     *   "url": "https://api.slack.com/block-kit"
     * }
     * ```
     * [View an example in Block Kit Builder](https://api.slack.com/tools/block-kit-builder?blocks=%5B%0A%09%7B%0A%09%09%22type%22%3A%20%22section%22%2C%0A%09%09%22text%22%3A%20%7B%0A%09%09%09%22type%22%3A%20%22mrkdwn%22%2C%0A%09%09%09%22text%22%3A%20%22This%20is%20a%20section%20block%20with%20a%20button.%22%0A%09%09%7D%2C%0A%09%09%22accessory%22%3A%20%7B%0A%09%09%09%22type%22%3A%20%22button%22%2C%0A%09%09%09%22text%22%3A%20%7B%0A%09%09%09%09%22type%22%3A%20%22plain_text%22%2C%0A%09%09%09%09%22text%22%3A%20%22Click%20Me%22%0A%09%09%09%7D%2C%0A%09%09%09%22value%22%3A%20%22click_me_123%22%2C%0A%09%09%09%22action_id%22%3A%20%22button%22%0A%09%09%7D%0A%09%7D%2C%0A%09%7B%0A%09%09%22type%22%3A%20%22actions%22%2C%0A%09%09%22block_id%22%3A%20%22actionblock789%22%2C%0A%09%09%22elements%22%3A%20%5B%0A%09%09%09%7B%0A%09%09%09%09%22type%22%3A%20%22button%22%2C%0A%09%09%09%09%22text%22%3A%20%7B%0A%09%09%09%09%09%22type%22%3A%20%22plain_text%22%2C%0A%09%09%09%09%09%22text%22%3A%20%22Primary%20Button%22%0A%09%09%09%09%7D%2C%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22style%22%3A%20%22primary%22%2C%0A%09%09%09%09%22value%22%3A%20%22click_me_456%22%0A%09%09%09%7D%2C%0A%09%09%09%7B%0A%09%09%09%09%22type%22%3A%20%22button%22%2C%0A%09%09%09%09%22text%22%3A%20%7B%0A%09%09%09%09%09%22type%22%3A%20%22plain_text%22%2C%0A%09%09%09%09%09%22text%22%3A%20%22Link%20Button%22%0A%09%09%09%09%7D%2C%0A%09%09%09%09%22url%22%3A%20%22https%3A%2F%2Fapi.slack.com%2Fblock-kit%22%0A%09%09%09%7D%0A%09%09%5D%0A%09%7D%0A%5D)
     */
    data class Button(
        /**
         * A text object that defines the button's text.
         * text may truncate with ~30 characters.
         * Maximum length for the text in this field is 75 characters.
         */
        val text: CompositionObject.Text.PlainText,
        /**
         * An identifier for this action.
         * You can use this when you receive an interaction payload to identify the source of the action.
         * Should be unique among all other `action_id`s in the containing block.
         * Maximum length is 255 characters.
         */
        @SerialName("action_id")
        val actionId: ActionID?,
        /**
         * A URL to load in the user's browser when the button is clicked.
         * Maximum length is 3000 characters.
         * If you're using url, you'll still receive an interaction payload
         * and will need to send an acknowledgement response.
         */
        val url: URL?,
        /**
         * The value to send along with the
         * [interaction payload](https://api.slack.com/interactivity/handling#payloads).
         * Maximum length is 2000 characters.
         */
        val value: String?,
        /**
         * Decorates buttons with alternative visual color schemes. Use this option with restraint.
         * If you don't include this field, the default button style will be used.
         */
        val style: Style?,
        /**
         * A [CompositionObject.ConfirmationDialog] object that defines an optional confirmation dialog after the button
         * is clicked.
         */
        val confirm: CompositionObject.ConfirmationDialog?,
        /**
         * A label for longer descriptive text about a button element.
         * This label will be read out by screen readers instead of the button [CompositionObject.Text] object.
         * Maximum length is 75 characters.
         */
        @SerialName("accessibility_label")
        val accessibilityLabel: String?
    ) : Element(type = Type.BUTTON) {

        enum class Style {
            /**
             * [DANGER] gives buttons a red outline and text, and should be used when the action is destructive.
             * Use [DANGER] even more sparingly than primary.
             */
            @SerialName("danger")
            DANGER,

            /**
             * [PRIMARY] gives buttons a green outline and text, ideal for affirmation or confirmation actions.
             * [PRIMARY] should only be used for one button within a set.
             */
            @SerialName("primary")
            PRIMARY,
        }
    }

    /**
     * Allows users to choose multiple items from a list of options.
     *
     * Interactive component - see the [guide to enabling interactivity](https://api.slack.com/interactivity/handling).
     *
     * Examples:
     * - A section block containing a group of checkboxes:
     * ```json
     * {
     * 	"type": "modal",
     * 	"title": {
     * 		"type": "plain_text",
     * 		"text": "My App",
     * 		"emoji": true
     * 	},
     * 	"submit": {
     * 		"type": "plain_text",
     * 		"text": "Submit",
     * 		"emoji": true
     * 	},
     * 	"close": {
     * 		"type": "plain_text",
     * 		"text": "Cancel",
     * 		"emoji": true
     * 	},
     * 	"blocks": [
     * 		{
     * 			"type": "section",
     * 			"text": {
     * 				"type": "plain_text",
     * 				"text": "Check out these charming checkboxes"
     * 			},
     * 			"accessory": {
     * 				"type": "checkboxes",
     * 				"action_id": "this_is_an_action_id",
     * 				"initial_options": [{
     * 					"value": "A1",
     * 					"text": {
     * 						"type": "plain_text",
     * 						"text": "Checkbox 1"
     * 					}
     * 				}],
     * 				"options": [
     * 					{
     * 						"value": "A1",
     * 						"text": {
     * 							"type": "plain_text",
     * 							"text": "Checkbox 1"
     * 						}
     * 					},
     * 					{
     * 						"value": "A2",
     * 						"text": {
     * 							"type": "plain_text",
     * 							"text": "Checkbox 2"
     * 						}
     * 					}
     * 				]
     * 			}
     * 		}
     * 	]
     * }
     * ```
     */
    data class Checkboxes(
        /**
         * An identifier for the action triggered when the checkbox group is changed.
         * You can use this when you receive an interaction payload to
         * [identify the source of the action](https://api.slack.com/interactivity/handling#payloads).
         * Should be unique among all other action_ids in the containing block.
         * Maximum length is 255 characters.
         */
        @SerialName("action_id")
        val actionId: ActionID?,
        /**
         * An array of option objects. A maximum of 10 options are allowed.
         */
        val options: Int,
        @SerialName("initial_options")
        val initialOptions: Int,
        /**
         * A [CompositionObject.ConfirmationDialog] object that defines an optional confirmation dialog that appears
         * after clicking one of the checkboxes in this element.
         */
        val confirm: CompositionObject.ConfirmationDialog?,
        @SerialName("focus_on_load")
        val focusOnLoad: Int
    ) : Element(type = Type.CHECKBOX)

    sealed interface RichText {
        sealed interface Input
    }
}
