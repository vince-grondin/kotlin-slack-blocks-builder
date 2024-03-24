package eth.rochsolid.slack.blocks.models.compositionobjects

import kotlinx.serialization.SerialName

/**
 * Defines an object containing some text.
 * Formatted either as [TextType.PLAIN_TEXT]
 * or using [TextType.MARKDOWN] (see [Surfaces > Formatting](https://api.slack.com/reference/surfaces/formatting)),
 * Slack's proprietary contribution to the much beloved Markdown standard.
 *
 * Example ([view in the Block Kit Builder](https://api.slack.com/tools/block-kit-builder?mode=message&blocks=%5B%7B%22type%22%3A%22section%22%2C%22text%22%3A%7B%22type%22%3A%22mrkdwn%22%2C%22text%22%3A%22A%20message%20*with%20some%20bold%20text*%20and%20_some%20italicized%20text_.%22%7D%7D%5D)):
 * ```json
 * {
 *     "type": "mrkdwn",
 *     "text": "A message *with some bold text* and _some italicized text_."
 * }
 * ```
 */
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

    data class Markdown(
        /**
         * The text for the block.
         * This field accepts any of the standard text formatting markup.
         * The minimum length is 1 and maximum length is 3000 characters.
         */
        val text: String,
        /**
         * When set to `false` (as is default) URLs will be auto-converted into links,
         * conversation names will be link-ified, and certain mentions will be
         * [automatically parsed](https://api.slack.com/reference/surfaces/formatting#automatic-parsing).
         * When set to `true`, Slack will continue to process all Markdown formatting and
         * [manual parsing strings](https://api.slack.com/reference/surfaces/formatting#advanced),
         * but it won’t modify any plain-text content. For example, channel names will not be hyperlinked.
         */
        val verbatim: Boolean? = false
    ) : Text(type = TextType.MARKDOWN)

    data class PlainText(
        val emoji: Boolean?,
        /**
         * The text for the block.
         * The minimum length is 1 and maximum length is 3000 characters.
         */
        val text: String,
    ) : Text(type = TextType.PLAIN_TEXT)
}
