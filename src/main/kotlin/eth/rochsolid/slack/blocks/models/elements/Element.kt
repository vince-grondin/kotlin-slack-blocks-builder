package eth.rochsolid.slack.blocks.models.elements

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
        CHECKBOXES,

        @SerialName("datepicker")
        DATE_PICKER,

        @SerialName("datetimepicker")
        DATETIME_PICKER,

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
}

sealed class ActionableElement(type: Type) : Element(type) {
    /**
     * An identifier for this action.
     * You can use this when you receive an interaction payload to identify the source of the action.
     * Should be unique among all other `action_id`s in the containing block.
     * Maximum length is 255 characters.
     */
    @SerialName("action_id")
    abstract val actionID: ActionID?

    /**
     * An action identifier.
     */
    @JvmInline
    @Serializable
    value class ActionID(val value: String)
}
