package eth.rochsolid.slack.blocks.models.elements

import eth.rochsolid.slack.blocks.models.compositionobjects.ConfirmationDialog
import eth.rochsolid.slack.blocks.models.compositionobjects.Text

/**
 * Allows users to select multiple items from a list of options.
 * Interactive component - see the [guide to enabling interactivity](https://api.slack.com/interactivity/handling).
 *
 * Just like regular select menus, multi-select menus also include type-ahead functionality, where a user can type a
 * part or all of an option string to filter the list.
 *
 * There are different types of multi-select menu that depend on different data sources for their lists of options:
 * - [MultiStaticSelect] Menu with static options
 * - Menu with external data source
 * - Menu with user list
 * - Menu with conversations list
 * - Menu with channels list
 */
sealed interface MultiSelect {
    /**
     * A [ConfirmationDialog] object that defines an optional confirmation dialog that appears
     * after clicking one of the checkboxes in this element.
     */
    val confirm: ConfirmationDialog?

    /**
     * Indicates whether the element will be set to autofocus within
     * the [view object](https://api.slack.com/reference/surfaces/views).
     * Only one element can be set to `true`. Defaults to `false`.
     */
    val focusOnLoad: Boolean?

    /**
     * Specifies the maximum number of items that can be selected in the menu.
     * Minimum number is 1.
     */
    val maxSelectedItems: Int?

    /**
     * Defines the placeholder text shown on the date picker.
     * Maximum length for the `text` in this field is 150 characters.
     */
    val placeholder: Text.PlainText?
}
