package eth.rochsolid.slack.blocks.models

import kotlinx.serialization.SerialName

sealed interface CompositionObject {
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

        data class PlainText(
            val emoji: Boolean?
        ) : Text(type = TextType.PLAIN_TEXT)
    }
}
