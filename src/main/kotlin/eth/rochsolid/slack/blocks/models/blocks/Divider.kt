package eth.rochsolid.slack.blocks.models.blocks

import kotlinx.serialization.SerialName

/**
 * Visually separates pieces of info inside a message.
 * A content divider, like an <hr>, to split up different blocks inside a message.
 * The divider block is nice and neat, requiring only a type.
 *
 * Example ([view this in Block Kit Builder](https://api.slack.com/tools/block-kit-builder?blocks=%5B%0A%20%20%20%20%7B%0A%20%20%20%20%20%20%20%20%22type%22%3A%20%22divider%22%2C%0A%20%20%20%20%09%22block_id%22%3A%20%22divider1%22%0A%20%20%20%20%7D%0A%5D)):
 * ```json
 * {
 *   "type": "divider"
 * }
 * ```
 */
data class Divider(
    /**
     * A unique identifier for a block. If not specified, a block_id will be generated by the Slack API.
     * You can use this [blockID] when you receive an interaction payload to identify the source of the action.
     * Maximum length for this field is 255 characters. [blockID] should be unique for each message and each iteration
     * of a message. If a message is updated, use a new [blockID].
     */
    @SerialName("block_id")
    override val blockID: BlockID?
) : Block(type = Type.DIVIDER)