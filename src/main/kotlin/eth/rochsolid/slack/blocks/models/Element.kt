package eth.rochsolid.slack.blocks.models

import kotlinx.serialization.SerialName

sealed interface Element {
    /**
     * The type of element.
     */
    val type: ElementType

    enum class ElementType {
        @SerialName("button")
        BUTTON,

        @SerialName("checkboxes")
        CHECKBOXES,

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
}