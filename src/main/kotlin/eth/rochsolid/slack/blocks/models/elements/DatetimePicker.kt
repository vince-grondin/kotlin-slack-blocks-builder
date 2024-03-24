package eth.rochsolid.slack.blocks.models.elements

import eth.rochsolid.slack.blocks.models.compositionobjects.ConfirmationDialog
import eth.rochsolid.slack.blocks.models.compositionobjects.Text
import kotlinx.serialization.SerialName
import java.time.Instant
import java.util.Date

/**
 * Allows users to select both a date and a time of day, formatted as a Unix timestamp.
 * Interactive component - see the [guide to enabling interactivity](https://api.slack.com/interactivity/handling).
 * On desktop clients, the time picker will take the form of a dropdown list and the date picker will take the form of a
 * dropdown calendar. Both options will have free-text entry for precise choices. On mobile clients, the time picker and
 * date picker will use native UIs.
 *
 * Example:
 * ```json
 * {
 *   "type": "input",
 *   "element": {
 *     "type": "datetimepicker",
 *     "action_id": "datetimepicker-action"
 *   },
 *   "hint": {
 *     "type": "plain_text",
 *     "text": "This is some hint text",
 *     "emoji": true
 *   },
 *   "label": {
 *     "type": "plain_text",
 *     "text": "Start date",
 *     "emoji": true
 *   }
 * }
 * ```
 */
data class DatetimePicker(
    /**
     * An identifier for this action.
     * You can use this when you receive an interaction payload to identify the source of the action.
     * Should be unique among all other `action_id`s in the containing block.
     * Maximum length is 255 characters.
     */
    @SerialName("action_id")
    val actionId: ActionID?,
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
     * The initial date and time that is selected when the element is loaded,
     * represented as a UNIX timestamp in seconds.
     * This should be in the format of 10 digits, for example `1628633820` represents the date and time
     * August 10th, 2021 at 03:17pm PST.
     */
    @SerialName("initial_date_time")
    val initialDateTime: Instant?
) : Element(type = Type.DATETIME_PICKER) {

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
