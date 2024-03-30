package eth.rochsolid.slack.blocks.models.elements

import eth.rochsolid.slack.blocks.models.compositionobjects.ConfirmationDialog
import eth.rochsolid.slack.blocks.models.compositionobjects.Text
import kotlinx.serialization.SerialName
import java.net.URL

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
    val text: Text.PlainText,
    /**
     * An identifier for this action.
     * You can use this when you receive an interaction payload to identify the source of the action.
     * Should be unique among all other `action_id`s in the containing block.
     * Maximum length is 255 characters.
     */
    @SerialName("action_id")
    override val actionID: ActionID?,
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
     * A [ConfirmationDialog] object that defines an optional confirmation dialog after the button
     * is clicked.
     */
    val confirm: ConfirmationDialog?,
    /**
     * Indicates whether the element will be set to autofocus within
     * the [view object](https://api.slack.com/reference/surfaces/views).
     * Only one element can be set to `true`. Defaults to `false`.
     */
    @SerialName("focus_on_load")
    val focusOnLoad: Boolean? = false,
    /**
     * A label for longer descriptive text about a button element.
     * This label will be read out by screen readers instead of the button [Text] object.
     * Maximum length is 75 characters.
     */
    @SerialName("accessibility_label")
    val accessibilityLabel: String?
) : ActionableElement(type = Type.BUTTON) {

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
