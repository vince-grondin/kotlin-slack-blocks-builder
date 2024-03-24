package eth.rochsolid.slack.blocks.models.compositionobjects

import kotlinx.serialization.Serializable
import java.net.URL


/**
 * Defines an object containing Slack file information to be used in an image block or image element.
 *
 * This [file](https://api.slack.com/types/file) must be an image, and you must provide either the URL or ID.
 * In addition, the user posting these blocks must have access to this file.
 * If both are provided then the payload will be rejected.
 * Currently only `png`, `jpg`, `jpeg`, and `gif` Slack image files are supported.
 */
sealed interface SlackFile {
    /**
     * Example:
     * ```json
     * {
     *   "slack_file": {
     *       "id": "F0123456",
     *   }
     * }
     * ```
     */
    data class IdSlackFile(
        /**
         * Slack ID of the file.
         */
        val id: ID
    ) : SlackFile {
        @JvmInline
        @Serializable
        value class ID(val value: String)
    }

    /**
     * Example:
     * ```json
     * {
     *   "slack_file": {
     *       "url": "https://files.slack.com/files-pri/T0123456-F0123456/xyz.png",
     *   }
     * }

     * ```
     */
    data class UrlSlackFile(
        /**
         * This URL can be the `url_private` or the `permalink` of the Slack file.
         */
        val url: URL
    ) : SlackFile
}
