package eth.rochsolid.slack.blocks.models.elements

import eth.rochsolid.slack.blocks.models.compositionobjects.*
import kotlinx.serialization.SerialName


/**
 * Allows users to select multiple items from a list of options.
 * Interactive component - see the [guide to enabling interactivity](https://api.slack.com/interactivity/handling).
 *
 * Just like regular select menus, multi-select menus also include type-ahead functionality, where a user can type a
 * part or all of an option string to filter the list.
 *
 * Example ([view this example in BlockKit Builder](https://api.slack.com/tools/block-kit-builder?blocks=%5B%7B%22type%22%3A%22section%22%2C%22block_id%22%3A%22section678%22%2C%22text%22%3A%7B%22type%22%3A%22mrkdwn%22%2C%22text%22%3A%22Pick%20items%20from%20the%20list%22%7D%2C%22accessory%22%3A%7B%22action_id%22%3A%22text1234%22%2C%22type%22%3A%22multi_static_select%22%2C%22placeholder%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22Select%20items%22%7D%2C%22options%22%3A%5B%7B%22text%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22*this%20is%20plain_text%20text*%22%7D%2C%22value%22%3A%22value-0%22%7D%2C%7B%22text%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22*this%20is%20plain_text%20text*%22%7D%2C%22value%22%3A%22value-1%22%7D%2C%7B%22text%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22*this%20is%20plain_text%20text*%22%7D%2C%22value%22%3A%22value-2%22%7D%5D%7D%7D%5D)):
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
 *       "type": "multi_static_select",
 *       "placeholder": {
 *         "type": "plain_text",
 *         "text": "Select items"
 *       },
 *       "options": [
 *         {
 *           "text": {
 *             "type": "plain_text",
 *             "text": "*this is plain_text text*"
 *           },
 *           "value": "value-0"
 *         },
 *         {
 *           "text": {
 *             "type": "plain_text",
 *             "text": "*this is plain_text text*"
 *           },
 *           "value": "value-1"
 *         },
 *         {
 *           "text": {
 *             "type": "plain_text",
 *             "text": "*this is plain_text text*"
 *           },
 *           "value": "value-2"
 *         }
 *       ]
 *     }
 *   }
 * ]
 * ```
 */
sealed class MultiStaticSelect : ActionableElement(type = Type.MULTI_STATIC_SELECT) {
    /**
     * A list of [Option] option objects that exactly matches one or more of the options within options.
     * These options will be selected when the checkbox group initially loads.
     */
    abstract val initialOptions: List<Option>?

    /**
     * A [ConfirmationDialog] object that defines an optional confirmation dialog that appears
     * after clicking one of the checkboxes in this element.
     */
    abstract val confirm: ConfirmationDialog?

    /**
     * Indicates whether the element will be set to autofocus within
     * the [view object](https://api.slack.com/reference/surfaces/views).
     * Only one element can be set to `true`. Defaults to `false`.
     */
    abstract val focusOnLoad: Boolean?

    /**
     * Specifies the maximum number of items that can be selected in the menu.
     * Minimum number is 1.
     */
    abstract val maxSelectedItems: Int?

    /**
     * Defines the placeholder text shown on the date picker.
     * Maximum length for the `text` in this field is 150 characters.
     */
    abstract val placeholder: Text.PlainText?

    /**
     * Multi-static select populated with [Option]s
     */
    data class OptionsMultiStaticSelect(
        /**
         * An identifier for this action.
         * You can use this when you receive an interaction payload to identify the source of the action.
         * Should be unique among all other `action_id`s in the containing block.
         * Maximum length is 255 characters.
         */
        @SerialName("action_id")
        override val actionID: ActionID?,
        /**
         * A list of [Option] option objects.
         * Maximum number of options is 100.
         * Each option must be less than 76 characters.
         * If option_groups is specified, this field should not be.
         */
        val options: List<Option>,
        /**
         * A list of [Option] option objects that exactly matches one or more of the options within options.
         * These options will be selected when the checkbox group initially loads.
         */
        @SerialName("initial_options")
        override val initialOptions: List<Option>?,
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
    ) : MultiStaticSelect()

    /**
     * Multi-static select populated with [OptionGroup]s
     */
    data class OptionsGroupsMultiStaticSelect(
        /**
         * An identifier for this action.
         * You can use this when you receive an interaction payload to identify the source of the action.
         * Should be unique among all other `action_id`s in the containing block.
         * Maximum length is 255 characters.
         */
        @SerialName("action_id")
        override val actionID: ActionID?,
        /**
         * A list of [OptionGroup] option group objects. Maximum number of option groups is 100.
         * If options is specified, this field should not be.
         */
        @SerialName("option_groups")
        val optionGroups: List<OptionGroup>,
        /**
         * A list of [Option] option objects that exactly matches one or more of the options within options.
         * These options will be selected when the checkbox group initially loads.
         */
        @SerialName("initial_options")
        override val initialOptions: List<Option>?,
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
    ) : MultiStaticSelect()
}
