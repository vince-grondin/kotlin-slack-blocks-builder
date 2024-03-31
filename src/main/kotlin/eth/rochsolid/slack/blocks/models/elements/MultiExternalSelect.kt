package eth.rochsolid.slack.blocks.models.elements

import eth.rochsolid.slack.blocks.models.compositionobjects.ConfirmationDialog
import eth.rochsolid.slack.blocks.models.compositionobjects.Option
import eth.rochsolid.slack.blocks.models.compositionobjects.Text
import kotlinx.serialization.SerialName

/**
 * This menu will load its options from an external data source, allowing for a dynamic list of options.
 *
 * To use this menu type, you'll need to configure your app first:
 *
 * 1. Go to your [app's settings page](https://api.slack.com/apps) and select **Interactivity & Shortcuts** from the
 * sidebar.
 * 1. Add a URL to the **Options Load URL** under Select Menus.
 * 1. Save changes.
 *
 * Each time a menu of this type is opened or the user starts typing in the typeahead field, Slack will send a request
 * to your specified URL. Your app should return an HTTP 200 OK response, along with an `application/json` post body
 * with an object containing either:
 * - an [Option] options array
 * - an [OptionGroup] `option_groups` array
 *
 * The `option_groups` array can have a maximum number of 100 option groups with a maximum of 100 options.
 *
 * Example:
 * ```json
 * [
 *   {
 *     "type": "section",
 *     "block_id": "section678",
 *     "text": {
 *       "type": "mrkdwn",
 *       "text": "Pick items from the list"
 *     },
 *     "accessory": {
 *       "action_id": "text1234",
 *       "type": "multi_external_select",
 *       "placeholder": {
 *         "type": "plain_text",
 *         "text": "Select items"
 *       },
 *       "min_query_length": 3
 *     }
 *   }
 * ]
 * ```
 */
data class MultiExternalSelect(
    /**
     * An identifier for this action.
     * You can use this when you receive an interaction payload to identify the source of the action.
     * Should be unique among all other `action_id`s in the containing block.
     * Maximum length is 255 characters.
     */
    @SerialName("action_id")
    override val actionID: ActionID?,
    /**
     * When the typeahead field is used, a request will be sent on every character change.
     * If you prefer fewer requests or more fully ideated queries, use the [minQueryLength] attribute to tell Slack the
     * fewest number of typed characters required before dispatch.
     * The default value is 3.
     */
    @SerialName("min_query_length")
    val minQueryLength: Int? = 3,
    /**
     * A list of [Option] option objects that exactly matches one or more of the options within options or
     * optionsGroups.
     * These options will be selected when the checkbox group initially loads.
     */
    @SerialName("initial_options")
    val initialOptions: List<Option>?,
    /**
     * A [ConfirmationDialog] object that defines an optional confirmation dialog that appears
     * after clicking one of the checkboxes in this element.
     */
    override val confirm: ConfirmationDialog?,
    /**
     * Specifies the maximum number of items that can be selected in the menu.
     * Minimum number is 1.
     */
    @SerialName("max_selected_items")
    override val maxSelectedItems: Int?,
    /**
     * Indicates whether the element will be set to autofocus within
     * the [view object](https://api.slack.com/reference/surfaces/views).
     * Only one element can be set to `true`. Defaults to `false`.
     */
    @SerialName("focus_on_load")
    override val focusOnLoad: Boolean? = false,
    /**
     * Defines the placeholder text shown on the date picker.
     * Maximum length for the `text` in this field is 150 characters.
     */
    override val placeholder: Text.PlainText?
) : ActionableElement(type = Type.MULTI_EXTERNAL_SELECT), MultiSelect
