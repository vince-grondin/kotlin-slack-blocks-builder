package eth.rochsolid.slack.blocks.models.blocks

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.net.URL


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

        /**
         * Example ([view this in Block Kit Builder](https://app.slack.com/block-kit-builder/T024BE7LD?_gl=1*eqr65a*_gcl_au*MTI4ODM0OTk1NS4xNzExMTc3MTY0#%7B%22blocks%22:%5B%7B%22type%22:%22rich_text%22,%22block_id%22:%22Vrzsu%22,%22elements%22:%5B%7B%22type%22:%22rich_text_quote%22,%22elements%22:%5B%7B%22type%22:%22text%22,%22text%22:%22What%20we%20need%20is%20good%20examples%20in%20our%20documentation.%22%7D%5D%7D,%7B%22type%22:%22rich_text_section%22,%22elements%22:%5B%7B%22type%22:%22text%22,%22text%22:%22Yes%20-%20I%20completely%20agree,%20Luke!%22%7D%5D%7D%5D%7D%5D%7D)):
         * ```json
         * {
         *   "type": "rich_text",
         *   "block_id": "Vrzsu",
         *   "elements": [
         *     {
         *       "type": "rich_text_quote",
         *       "elements": [
         *         {
         *           "type": "text",
         *           "text": "What we need is good examples in our documentation."
         *         }
         *       ]
         *     },
         *     {
         *       "type": "rich_text_section",
         *       "elements": [
         *         {
         *           "type": "text",
         *           "text": "Yes - I completely agree, Luke!"
         *         }
         *       ]
         *     }
         *   ]
         * }
         * ```
         */
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

        /**
         * Examples:
         * - rich text list ([view this in Block Kit Builder](https://app.slack.com/block-kit-builder/T024BE7LD?_gl=1*1w1towr*_gcl_au*MTI4ODM0OTk1NS4xNzExMTc3MTY0#%7B%22blocks%22:%5B%7B%22type%22:%22rich_text%22,%22block_id%22:%22block1%22,%22elements%22:%5B%7B%22type%22:%22rich_text_section%22,%22elements%22:%5B%7B%22type%22:%22text%22,%22text%22:%22My%20favorite%20Slack%20features%20(in%20no%20particular%20order):%22%7D%5D%7D,%7B%22type%22:%22rich_text_list%22,%22elements%22:%5B%7B%22type%22:%22rich_text_section%22,%22elements%22:%5B%7B%22type%22:%22text%22,%22text%22:%22Huddles%22%7D%5D%7D,%7B%22type%22:%22rich_text_section%22,%22elements%22:%5B%7B%22type%22:%22text%22,%22text%22:%22Canvas%22%7D%5D%7D,%7B%22type%22:%22rich_text_section%22,%22elements%22:%5B%7B%22type%22:%22text%22,%22text%22:%22Developing%20with%20Block%20Kit%22%7D%5D%7D%5D,%22style%22:%22bullet%22,%22indent%22:0,%22border%22:1%7D%5D%7D%5D%7D))
         * ```json
         * {
         *   "type": "rich_text",
         *   "block_id": "block1",
         *   "elements": [
         *     {
         *       "type": "rich_text_section",
         *       "elements": [
         *         {
         *           "type": "text",
         *           "text": "My favorite Slack features (in no particular order):"
         *         }
         *       ]
         *     },
         *     {
         *       "type": "rich_text_list",
         *       "elements": [
         *         {
         *           "type": "rich_text_section",
         *           "elements": [
         *             {
         *               "type": "text",
         *               "text": "Huddles"
         *             }
         *           ]
         *         },
         *         {
         *           "type": "rich_text_section",
         *           "elements": [
         *             {
         *               "type": "text",
         *               "text": "Canvas"
         *             }
         *           ]
         *         },
         *         {
         *           "type": "rich_text_section",
         *           "elements": [
         *             {
         *               "type": "text",
         *               "text": "Developing with Block Kit"
         *             }
         *           ]
         *         }
         *       ],
         *       "style": "bullet",
         *       "indent": 0,
         *       "border": 1
         *     },
         *   ],
         * }
         * ```
         * - nested list rich text list ([view this in Block Kit Builder](https://app.slack.com/block-kit-builder/T024BE7LD?_gl=1*xijy61*_gcl_au*MTI4ODM0OTk1NS4xNzExMTc3MTY0#%7B%22blocks%22:%5B%7B%22type%22:%22rich_text%22,%22block_id%22:%22block1%22,%22elements%22:%5B%7B%22type%22:%22rich_text_section%22,%22elements%22:%5B%7B%22type%22:%22text%22,%22text%22:%22Breakfast%20foods%20I%20enjoy:%22%7D%5D%7D,%7B%22type%22:%22rich_text_list%22,%22style%22:%22bullet%22,%22elements%22:%5B%7B%22type%22:%22rich_text_section%22,%22elements%22:%5B%7B%22type%22:%22text%22,%22text%22:%22Hashbrowns%22%7D%5D%7D,%7B%22type%22:%22rich_text_section%22,%22elements%22:%5B%7B%22type%22:%22text%22,%22text%22:%22Eggs%22%7D%5D%7D%5D%7D,%7B%22type%22:%22rich_text_list%22,%22style%22:%22bullet%22,%22indent%22:1,%22elements%22:%5B%7B%22type%22:%22rich_text_section%22,%22elements%22:%5B%7B%22type%22:%22text%22,%22text%22:%22Scrambled%22%7D%5D%7D,%7B%22type%22:%22rich_text_section%22,%22elements%22:%5B%7B%22type%22:%22text%22,%22text%22:%22Over%20easy%22%7D%5D%7D%5D%7D,%7B%22type%22:%22rich_text_list%22,%22style%22:%22bullet%22,%22elements%22:%5B%7B%22type%22:%22rich_text_section%22,%22elements%22:%5B%7B%22type%22:%22text%22,%22text%22:%22Pancakes,%20extra%20syrup%22%7D%5D%7D%5D%7D%5D%7D%5D%7D))
         * ```json
         * {
         *   "type": "rich_text",
         *   "block_id": "block1",
         *   "elements": [
         *     {
         *       "type": "rich_text_section",
         *       "elements": [
         *         {
         *           "type": "text",
         *           "text": "Breakfast foods I enjoy:"
         *         }
         *       ]
         *     },
         *     {
         *       "type": "rich_text_list",
         *       "style": "bullet",
         *       "elements": [
         *         {
         *           "type": "rich_text_section",
         *           "elements": [
         *             {
         *               "type": "text",
         *               "text": "Hashbrowns"
         *             }
         *           ]
         *         },
         *         {
         *           "type": "rich_text_section",
         *           "elements": [
         *             {
         *               "type": "text",
         *               "text": "Eggs"
         *             }
         *           ]
         *         }
         *       ]
         *     },
         *     {
         *       "type": "rich_text_list",
         *       "style": "bullet",
         *       "indent": 1,
         *       "elements": [
         *         {
         *           "type": "rich_text_section",
         *           "elements": [
         *             {
         *               "type": "text",
         *               "text": "Scrambled"
         *             }
         *           ]
         *         },
         *         {
         *           "type": "rich_text_section",
         *           "elements": [
         *             {
         *               "type": "text",
         *               "text": "Over easy"
         *             }
         *           ]
         *         }
         *       ]
         *     },
         *     {
         *       "type": "rich_text_list",
         *       "style": "bullet",
         *       "elements": [
         *         {
         *           "type": "rich_text_section",
         *           "elements": [
         *             {
         *               "type": "text",
         *               "text": "Pancakes, extra syrup"
         *             }
         *           ]
         *         }
         *       ]
         *     }
         *   ]
         * }
         * ```
         */
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

        /**
         * Example ([view this in Block Kit Builder](https://app.slack.com/block-kit-builder/?_gl=1*14fkk6u*_gcl_au*MTI4ODM0OTk1NS4xNzExMTc3MTY0#%7B%22blocks%22:%5B%7B%22type%22:%22rich_text%22,%22elements%22:%5B%7B%22type%22:%22rich_text_section%22,%22elements%22:%5B%7B%22type%22:%22text%22,%22text%22:%22Hello%20there,%20I%20am%20a%20basic%20rich%20text%20block!%22%7D%5D%7D%5D%7D,%7B%22type%22:%22rich_text%22,%22elements%22:%5B%7B%22type%22:%22rich_text_section%22,%22elements%22:%5B%7B%22type%22:%22text%22,%22text%22:%22Hello%20there,%20%22%7D,%7B%22type%22:%22text%22,%22text%22:%22I%20am%20a%20bold%20rich%20text%20block!%22,%22style%22:%7B%22bold%22:true%7D%7D%5D%7D%5D%7D,%7B%22type%22:%22rich_text%22,%22elements%22:%5B%7B%22type%22:%22rich_text_section%22,%22elements%22:%5B%7B%22type%22:%22text%22,%22text%22:%22Hello%20there,%20%22%7D,%7B%22type%22:%22text%22,%22text%22:%22I%20am%20an%20italic%20rich%20text%20block!%22,%22style%22:%7B%22italic%22:true%7D%7D%5D%7D%5D%7D,%7B%22type%22:%22rich_text%22,%22elements%22:%5B%7B%22type%22:%22rich_text_section%22,%22elements%22:%5B%7B%22type%22:%22text%22,%22text%22:%22Hello%20there,%20%22%7D,%7B%22type%22:%22text%22,%22text%22:%22I%20am%20a%20strikethrough%20rich%20text%20block!%22,%22style%22:%7B%22strike%22:true%7D%7D%5D%7D%5D%7D%5D%7D)):
         * ```json
         * {
         * "type": "rich_text",
         *   "elements": [
         *     {
         *       "type": "rich_text_section",
         *       "elements": [
         *         {
         *           "type": "text",
         *           "text": "Hello there, I am a basic rich text block!"
         *         }
         *       ]
         *     }
         *   ]
         * },
         * {
         *   "type": "rich_text",
         *   "elements": [
         *     {
         *       "type": "rich_text_section",
         *       "elements": [
         *         {
         *           "type": "text",
         *           "text": "Hello there, "
         *         },
         *         {
         *           "type": "text",
         *           "text": "I am a bold rich text block!",
         *           "style": {
         *             "bold": true
         *           }
         *         }
         *       ]
         *     }
         *   ]
         * },
         * {
         *   "type": "rich_text",
         *   "elements": [
         *     {
         *       "type": "rich_text_section",
         *       "elements": [
         *         {
         *           "type": "text",
         *           "text": "Hello there, "
         *         },
         *         {
         *           "type": "text",
         *           "text": "I am an italic rich text block!",
         *           "style": {
         *             "italic": true
         *           }
         *         }
         *       ]
         *     }
         *   ]
         * },
         * {
         *   "type": "rich_text",
         *   "elements": [
         *     {
         *       "type": "rich_text_section",
         *       "elements": [
         *         {
         *           "type": "text",
         *           "text": "Hello there, "
         *         },
         *         {
         *           "type": "text",
         *           "text": "I am a strikethrough rich text block!",
         *           "style": {
         *             "strike": true
         *           }
         *         }
         *       ]
         *     }
         *   ]
         * }
         * ```
         */
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

            /**
             * An object of optional boolean properties that dictate style.
             */
            data class Style(
                val bold: Boolean?,
                val code: Boolean?,
                val italic: Boolean?,
                val strike: Boolean?
            )

            /**
             * An object of optional boolean properties that dictate style, including highlighting options.
             */
            data class StyleWithHighlightOptions(
                val bold: Boolean?,
                val italic: Boolean?,
                val strike: Boolean?,
                val highlight: Boolean?,
                @SerialName("client_highlight") val clientHighlight: Boolean?,
                val unlink: Boolean?
            )

            data class Channel(
                /**
                 * The ID of the channel to be mentioned.
                 */
                val channelID: ChannelID,
                /**
                 * An object of optional boolean properties that dictate style.
                 */
                val style: StyleWithHighlightOptions?
            ) : SubElement(type = Type.CHANNEL) {
                /**
                 * The ID of a channel.
                 */
                @JvmInline
                @Serializable
                value class ChannelID(val value: String)
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
            ) : SubElement(type = Type.LINK)

            data class Text(
                /**
                 * An object of optional boolean properties that dictate style.
                 */
                val style: Style?
            ) : SubElement(type = Type.TEXT)

            data class User(
                /**
                 * An object of optional boolean properties that dictate style.
                 */
                val style: StyleWithHighlightOptions?,
                /**
                 * The ID of the user to be mentioned.
                 */
                @SerialName("user_id")
                val userID: UserID
            ) : SubElement(type = Type.USER) {
                /**
                 * A user ID.
                 */
                @JvmInline
                @Serializable
                value class UserID(val value: String)
            }

            data class UserGroup(
                /**
                 * An object of optional boolean properties that dictate style.
                 */
                val style: Style?,
                /**
                 * The ID of the user group to be mentioned.
                 */
                @SerialName("usergroup_id")
                val userGroupID: UserGroupID
            ) : SubElement(type = Type.USERGROUP) {
                /**
                 * A user group ID.
                 */
                @JvmInline
                @Serializable
                value class UserGroupID(val value: String)
            }
        }
    }
}