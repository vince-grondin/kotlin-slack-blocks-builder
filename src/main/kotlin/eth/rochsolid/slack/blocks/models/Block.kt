package eth.rochsolid.slack.blocks.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.net.URL

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

    /**
     * Holds multiple interactive [Element]s.
     */
    data class Actions(
        /**
         * A unique identifier for a block. If not specified, a block_id will be generated by the Slack API.
         * You can use this [blockID] when you receive an interaction payload to identify the source of the action.
         * Maximum length for this field is 255 characters. [blockID] should be unique for each message and each iteration
         * of a message. If a message is updated, use a new [blockID].
         */
        @SerialName("block_id")
        override val blockID: BlockID?,
        /**
         * An array of interactive element objects - buttons, select menus, overflow menus, or date pickers.
         * There is a maximum of 25 elements in each action block.
         */
        val elements: List<Element>
    ) : Block(type = Type.ACTIONS)

    /**
     * Displays contextual info, which can include both images and text.
     */
    data class Context(
        /**
         * A unique identifier for a block. If not specified, a block_id will be generated by the Slack API.
         * You can use this [blockID] when you receive an interaction payload to identify the source of the action.
         * Maximum length for this field is 255 characters. [blockID] should be unique for each message and each iteration
         * of a message. If a message is updated, use a new [blockID].
         */
        @SerialName("block_id")
        override val blockID: BlockID?,
        /**
         * An array of image elements and text objects. Maximum number of items is 10.
         */
        val elements: List<Element>
    ) : Block(type = Type.CONTEXT)

    /**
     * Visually separates pieces of info inside a message.
     * A content divider, like an <hr>, to split up different blocks inside a message.
     * The divider block is nice and neat, requiring only a type.
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

    /**
     * Displays a [remote file](https://api.slack.com/messaging/files#remote).
     * You can't add this block to app surfaces directly, but it will show up when
     * [retrieving messages](https://api.slack.com/messaging/retrieving) that contain remote files.
     * If you want to add remote files to messages, [follow the guide](https://api.slack.com/messaging/files#remote).
     */
    data class File(
        /**
         * A unique identifier for a block. If not specified, a block_id will be generated by the Slack API.
         * You can use this [blockID] when you receive an interaction payload to identify the source of the action.
         * Maximum length for this field is 255 characters. [blockID] should be unique for each message and each iteration
         * of a message. If a message is updated, use a new [blockID].
         */
        @SerialName("block_id")
        override val blockID: BlockID?,
        /**
         * The external unique ID for this file.
         */
        val externalID: ExternalID,
        /**
         * At the moment, source will always be remote for a remote file.
         */
        val source: Source
    ) : Block(type = Type.FILE) {
        /**
         * The external unique ID for a file.
         */
        @JvmInline
        @Serializable
        value class ExternalID(val value: String)

        /**
         * At the moment, source will always be remote for a remote file.
         */
        enum class Source {
            @SerialName("remote")
            REMOTE
        }
    }

    /**
     * Displays a larger-sized text block.
     * A header is a plain-text block that displays in a larger, bold font.
     * Use it to delineate between different groups of content in your app's surfaces.
     */
    data class Header(
        /**
         * A unique identifier for a block. If not specified, a block_id will be generated by the Slack API.
         * You can use this [blockID] when you receive an interaction payload to identify the source of the action.
         * Maximum length for this field is 255 characters. [blockID] should be unique for each message and each iteration
         * of a message. If a message is updated, use a new [blockID].
         */
        @SerialName("block_id")
        override val blockID: BlockID?,
        /**
         * The text for the block, in the form of a [CompositionObject.Text.PlainText] text object.
         * Maximum length for the text in this field is 150 characters.
         */
        val text: CompositionObject.Text.PlainText
    ) : Block(type = Type.HEADER)

    /**
     * Displays an image.
     */
    sealed class Image : Block(type = Type.IMAGE) {
        abstract val altText: String
        abstract val title: CompositionObject.Text.PlainText?

        data class Url(
            /**
             * A unique identifier for a block. If not specified, a block_id will be generated by the Slack API.
             * You can use this [blockID] when you receive an interaction payload to identify the source of the action.
             * Maximum length for this field is 255 characters. [blockID] should be unique for each message and each iteration
             * of a message. If a message is updated, use a new [blockID].
             */
            @SerialName("block_id")
            override val blockID: BlockID?,
            /**
             * A plain-text summary of the image. This should not contain any markup.
             * Maximum length for this field is 2000 characters.
             */
            @SerialName("alt_text")
            override val altText: String,
            /**
             * The URL for a publicly hosted image.
             * You must provide either an image_url or slack_file. Maximum length for this field is 3000 characters.
             */
            @SerialName("image_url")
            val imageUrl: String?,
            /**
             * An optional title for the image in the form.
             * Maximum length for the text in this field is 2000 characters.
             */
            override val title: CompositionObject.Text.PlainText?
        ) : Image()

        /**
         * A [Slack image file object](https://api.slack.com/reference/block-kit/composition-objects#slack_file) that
         * defines the source of the image.
         */
        data class SlackFile(
            /**
             * A unique identifier for a block. If not specified, a block_id will be generated by the Slack API.
             * You can use this [blockID] when you receive an interaction payload to identify the source of the action.
             * Maximum length for this field is 255 characters. [blockID] should be unique for each message and each iteration
             * of a message. If a message is updated, use a new [blockID].
             */
            @SerialName("block_id")
            override val blockID: BlockID?,
            /**
             * A plain-text summary of the image. This should not contain any markup.
             * Maximum length for this field is 2000 characters.
             */
            @SerialName("alt_text")
            override val altText: String,
            /**
             * An optional title for the image in the form.
             * Maximum length for the text in this field is 2000 characters.
             */
            override val title: CompositionObject.Text.PlainText?
        ) : Image()
    }

    /**
     * Collects information from users via block elements.
     * Read the guides to collecting input in [modals](https://api.slack.com/surfaces/modals#gathering_input) or
     * [in Home tabs](https://api.slack.com/surfaces/app-home#gathering_input) to learn how input blocks pass
     * information to your app.
     */
    data class Input(
        /**
         * A unique identifier for a block. If not specified, a block_id will be generated by the Slack API.
         * You can use this [blockID] when you receive an interaction payload to identify the source of the action.
         * Maximum length for this field is 255 characters. [blockID] should be unique for each message and each iteration
         * of a message. If a message is updated, use a new [blockID].
         */
        @SerialName("block_id")
        override val blockID: BlockID?,
        /**
         * A label that appears above an input element in the form of a [CompositionObject.Text.PlainText].
         * Maximum length for the text in this field is 2000 characters.
         */
        val label: CompositionObject.Text.PlainText,
        /**
         * A [Element]
         */
        val element: Block,
        /**
         * A boolean that indicates whether the use of elements in this block should dispatch
         * a [block_actions](https://api.slack.com/reference/interaction-payloads/block-actions) payload.
         * Defaults to `false`.
         */
        @SerialName("dispatch_action")
        val dispatchAction: Boolean? = false,
        /**
         * An optional hint that appears below an input element in a lighter grey.
         * Maximum length for the text in this field is 2000 characters.
         */
        val hint: CompositionObject.Text.PlainText?,
        /**
         * A boolean that indicates whether the input element may be empty when a user submits the modal.
         * Defaults to false.
         */
        val optional: Boolean? = false
    ) : Block(type = Type.INPUT)

    /**
     * Displays formatted, structured representation of text.
     *
     * It is also the output of the Slack client's WYSIWYG message composer,
     * so all messages sent by end-users will have this format.
     * Use this block to include user-defined formatted text in your Block Kit payload.
     * While it is possible to format text with Markdown, rich text is strongly preferred and
     * allows greater flexibility.
     *
     * You might encounter a rich_text block in a message payload, as a built-in type in workflow apps,
     * or as output of the [Element.RichText.Input] block element.
     *
     * Rich text blocks can be deeply nested. For example: a rich_text_list can contain a rich_text_section which can
     * contain bold style text. More details on how that works is shown in the examples.
     *
     * Sub-elements are what comprise the elements array in a rich text block.
     * There are four available rich text object sub-elements.: rich_text_section, rich_text_list,
     * rich_text_preformatted, and rich_text_quote.
     * Because many of the elements include a section block, the details of that element are listed first,
     * followed by the others.
     */
    data class RichText(
        /**
         * A unique identifier for a block. If not specified, a block_id will be generated by the Slack API.
         * You can use this [blockID] when you receive an interaction payload to identify the source of the action.
         * Maximum length for this field is 255 characters. [blockID] should be unique for each message and each
         * iteration of a message. If a message is updated, use a new [blockID].
         */
        @SerialName("block_id")
        override val blockID: BlockID?,
        /**
         * A list of rich text objects.
         */
        val elements: List<Element>
    ) : Block(type = Type.RICH_TEXT) {
        sealed class Element(val type: Type) {
            enum class Type {
                @SerialName("rich_text_section")
                RICH_TEXT_SECTION,

                @SerialName("rich_text_list")
                RICH_TEXT_LIST,

                @SerialName("rich_text_preformatted")
                RICH_TEXT_PREFORMATTED,

                @SerialName("rich_text_quote")
                RICH_TEXT_QUOTE,
            }

            data class Preformatted(
                /**
                 * Number of pixels of border thickness.
                 */
                val border: Int?,
                /**
                 * A list of rich text sub-elements.
                 */
                val elements: List<SubElement>
            ) : Element(type = Type.RICH_TEXT_PREFORMATTED)

            data class Quote(
                /**
                 * Number of pixels of border thickness.
                 */
                val border: Int?,
                /**
                 * A list of rich text sub-elements.
                 */
                val elements: List<SubElement>
            ) : Element(type = Type.RICH_TEXT_PREFORMATTED)

            data class RichTextList(
                /**
                 * Number of pixels of border thickness.
                 */
                val border: Int?,
                /**
                 * A list of rich text sub-elements.
                 */
                val elements: List<Section>,
                /**
                 * Number of pixels to indent the list.
                 */
                val indent: Int?,
                /**
                 * Number of pixels to offset the list.
                 */
                val offset: Int?,
                val style: Style
            ) : Element(type = Type.RICH_TEXT_LIST) {
                enum class Style {
                    @SerialName("bullet")
                    BULLET,

                    @SerialName("ordered")
                    ORDERED
                }
            }

            data class Section(
                /**
                 * A list of rich text sub-elements.
                 */
                val elements: List<SubElement>
            ) : Element(type = Type.RICH_TEXT_SECTION)

            sealed class SubElement(val type: Type) {
                enum class Type {
                    @SerialName("channel")
                    CHANNEL,

                    @SerialName("emoji")
                    EMOJI,

                    @SerialName("link")
                    LINK,

                    @SerialName("text")
                    TEXT,

                    @SerialName("user")
                    USER,

                    @SerialName("usergroup")
                    USERGROUP
                }

                data class Channel(
                    /**
                     * The ID of the channel to be mentioned.
                     */
                    val channelID: ChannelID,
                    /**
                     * An object of optional boolean properties that dictate style.
                     */
                    val style: Style?
                ) : SubElement(type = Type.CHANNEL) {
                    /**
                     * The ID of a channel.
                     */
                    @JvmInline
                    @Serializable
                    value class ChannelID(val value: String)

                    /**
                     * An object of optional boolean properties that dictate style.
                     */
                    data class Style(
                        val bold: Boolean?,
                        val italic: Boolean?,
                        val strike: Boolean?,
                        val highlight: Boolean?,
                        @SerialName("client_highlight") val clientHighlight: Boolean?,
                        val unlink: Boolean?
                    )
                }

                data class Emoji(
                    /**
                     * The name of the emoji; i.e. "wave" or "wave::skin-tone-2".
                     */
                    val name: String
                ) : SubElement(type = Type.EMOJI)

                data class Link(
                    val style: Style?,
                    /**
                     * The text shown to the user (instead of the url). If no text is provided, the url is used.
                     */
                    val text: String?,
                    /**
                     * Indicates whether the link is safe.
                     */
                    val unsafe: Boolean?,
                    /**
                     * The link's url.
                     */
                    val url: URL
                ) : SubElement(type = Type.LINK) {
                    /**
                     * An object of optional boolean properties that dictate style.
                     */
                    data class Style(
                        val bold: Boolean?,
                        val code: Boolean?,
                        val italic: Boolean?,
                        val strike: Boolean?
                    )
                }
            }
        }
    }
}
