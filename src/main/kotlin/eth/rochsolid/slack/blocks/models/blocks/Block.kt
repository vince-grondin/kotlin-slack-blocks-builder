package eth.rochsolid.slack.blocks.models.blocks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Blocks are a series of components that can be combined to create visually rich and compellingly interactive messages.
 * Read the guide to [building block layouts](https://api.slack.com/block-kit/building) to learn where and how to use
 * each of these components. You can include up to 50 blocks in each message, and 100 blocks in modals or Home tabs.
 */
@Serializable
sealed class Block(
    /**
     * The type of block.
     */
    val type: Type
) {
    abstract val blockID: BlockID?

    /**
     * A unique identifier for a block. Maximum length for this field is 255 characters.
     */
    @JvmInline
    @Serializable
    value class BlockID(val value: String)

    /**
     * The type of block.
     */
    @Serializable
    enum class Type {
        @SerialName("actions")
        ACTIONS,

        @SerialName("context")
        CONTEXT,

        @SerialName("divider")
        DIVIDER,

        @SerialName("file")
        FILE,

        @SerialName("header")
        HEADER,

        @SerialName("image")
        IMAGE,

        @SerialName("input")
        INPUT,

        @SerialName("rich_text")
        RICH_TEXT,

        @SerialName("section")
        SECTION,

        @SerialName("video")
        VIDEO,
    }
}
