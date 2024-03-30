package eth.rochsolid.slack.blocks.models.elements

import eth.rochsolid.slack.blocks.models.blocks.Image
import kotlinx.serialization.SerialName
import java.net.URL

/**
 * Displays an image as part of a larger block of content.
 * Use the [Image] block if you want a block with only an image in it.
 *
 * Example ([view this example in the Block Kit Builder](https://api.slack.com/tools/block-kit-builder?blocks=%5B%0A%09%7B%0A%09%09%22type%22%3A%20%22section%22%2C%0A%09%09%22block_id%22%3A%20%22section567%22%2C%0A%09%09%22text%22%3A%20%7B%0A%09%09%09%22type%22%3A%20%22mrkdwn%22%2C%0A%09%09%09%22text%22%3A%20%22This%20is%20a%20section%20block%20with%20an%20accessory%20image.%22%0A%09%09%7D%2C%0A%09%09%22accessory%22%3A%20%7B%0A%09%09%09%22type%22%3A%20%22image%22%2C%0A%09%09%09%22image_url%22%3A%20%22https%3A%2F%2Fpbs.twimg.com%2Fprofile_images%2F625633822235693056%2FlNGUneLX_400x400.jpg%22%2C%0A%09%09%09%22alt_text%22%3A%20%22cute%20cat%22%0A%09%09%7D%0A%09%7D%0A%5D)):
 * ```json
 * {
 *   "type": "image",
 *   "image_url": "http://placekitten.com/700/500",
 *   "alt_text": "Multiple cute kittens"
 * }
 * ```
 */
sealed class Image(
    /**
     * A plain-text summary of the image. This should not contain any markup.
     */
    @SerialName("alt_text")
    val altText: String,
) : Element(type = Type.IMAGE) {
    data class UrlImage(
        /**
         * The URL for a publicly hosted image. Maximum length for this field is 3000 characters.
         */
        @SerialName("image_url")
        val imageUrl: URL
    )

    data class SlackFileImage(
        /**
         * A [Image.SlackFile] Slack image file object that defines the source of the image.
         */
        @SerialName("slack_file")
        val slackFile: Image.SlackFile
    )
}
