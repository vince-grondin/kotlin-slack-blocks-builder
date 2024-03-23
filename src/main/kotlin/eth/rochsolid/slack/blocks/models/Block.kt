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
     *
     * Examples:
     * - An actions block with a select menu and a button ([view this in Block Kit Builder](https://api.slack.com/tools/block-kit-builder?blocks=%5B%0A%09%7B%0A%20%20%20%20%20%20%22type%22%3A%20%22actions%22%2C%0A%20%20%20%20%20%20%22block_id%22%3A%20%22actions1%22%2C%0A%20%20%20%20%20%20%22elements%22%3A%20%5B%0A%20%20%20%20%20%20%20%20%7B%0A%20%20%20%20%20%20%20%20%20%20%22type%22%3A%20%22static_select%22%2C%0A%20%20%20%20%20%20%20%20%20%20%22placeholder%22%3A%7B%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22type%22%3A%20%22plain_text%22%2C%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22text%22%3A%20%22Which%20witch%20is%20the%20witchiest%20witch%3F%22%0A%20%20%20%20%20%20%20%20%20%20%7D%2C%0A%20%20%20%20%20%20%20%20%20%20%22action_id%22%3A%20%22select_2%22%2C%0A%20%20%20%20%20%20%20%20%20%20%22options%22%3A%20%5B%0A%20%20%20%20%20%20%20%20%20%20%20%20%7B%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22text%22%3A%20%7B%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22type%22%3A%20%22plain_text%22%2C%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22text%22%3A%20%22Matilda%22%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%7D%2C%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22value%22%3A%20%22matilda%22%0A%20%20%20%20%20%20%20%20%20%20%20%20%7D%2C%0A%20%20%20%20%20%20%20%20%20%20%20%20%7B%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22text%22%3A%20%7B%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22type%22%3A%20%22plain_text%22%2C%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22text%22%3A%20%22Glinda%22%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%7D%2C%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22value%22%3A%20%22glinda%22%0A%20%20%20%20%20%20%20%20%20%20%20%20%7D%2C%0A%20%20%20%20%20%20%20%20%20%20%20%20%7B%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22text%22%3A%20%7B%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22type%22%3A%20%22plain_text%22%2C%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22text%22%3A%20%22Granny%20Weatherwax%22%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%7D%2C%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22value%22%3A%20%22grannyWeatherwax%22%0A%20%20%20%20%20%20%20%20%20%20%20%20%7D%2C%0A%20%20%20%20%20%20%20%20%20%20%20%20%7B%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22text%22%3A%20%7B%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22type%22%3A%20%22plain_text%22%2C%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22text%22%3A%20%22Hermione%22%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%7D%2C%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22value%22%3A%20%22hermione%22%0A%20%20%20%20%20%20%20%20%20%20%20%20%7D%0A%20%20%20%20%20%20%20%20%20%20%5D%0A%20%20%20%20%20%20%20%20%7D%2C%0A%20%20%20%20%20%20%20%20%7B%0A%20%20%20%20%20%20%20%20%20%20%22type%22%3A%20%22button%22%2C%0A%20%20%20%20%20%20%20%20%20%20%22text%22%3A%20%7B%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22type%22%3A%20%22plain_text%22%2C%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22text%22%3A%20%22Cancel%22%0A%20%20%20%20%20%20%20%20%20%20%7D%2C%0A%20%20%20%20%20%20%20%20%20%20%22value%22%3A%20%22cancel%22%2C%0A%20%20%20%20%20%20%20%20%20%20%22action_id%22%3A%20%22button_1%22%0A%20%20%20%20%20%20%20%20%7D%0A%20%20%20%20%20%20%5D%0A%20%20%20%20%7D%0A%5D))
     * ```json
     * {
     *   "type": "actions",
     *   "block_id": "actions1",
     *   "elements": [
     *     {
     *       "type": "static_select",
     *       "placeholder":{
     *           "type": "plain_text",
     *           "text": "Which witch is the witchiest witch?"
     *       },
     *       "action_id": "select_2",
     *       "options": [
     *         {
     *           "text": {
     *               "type": "plain_text",
     *               "text": "Matilda"
     *           },
     *           "value": "matilda"
     *         },
     *         {
     *           "text": {
     *               "type": "plain_text",
     *               "text": "Glinda"
     *           },
     *           "value": "glinda"
     *         },
     *         {
     *           "text": {
     *               "type": "plain_text",
     *               "text": "Granny Weatherwax"
     *           },
     *           "value": "grannyWeatherwax"
     *         },
     *         {
     *           "text": {
     *               "type": "plain_text",
     *               "text": "Hermione"
     *           },
     *           "value": "hermione"
     *         }
     *       ]
     *     },
     *     {
     *       "type": "button",
     *       "text": {
     *           "type": "plain_text",
     *           "text": "Cancel"
     *       },
     *       "value": "cancel",
     *       "action_id": "button_1"
     *     }
     *   ]
     * }
     * ```
     * - An actions block with a datepicker, an overflow, and a button ([view this in Block Kit Builder](https://api.slack.com/tools/block-kit-builder?blocks=%5B%0A%09%7B%0A%09%09%22type%22%3A%20%22actions%22%2C%0A%09%09%22block_id%22%3A%20%22actionblock789%22%2C%0A%09%09%22elements%22%3A%20%5B%0A%09%09%09%7B%0A%09%09%09%09%22type%22%3A%20%22datepicker%22%2C%0A%09%09%09%09%22action_id%22%3A%20%22datepicker123%22%2C%0A%09%09%09%09%22initial_date%22%3A%20%221990-04-28%22%2C%0A%09%09%09%09%22placeholder%22%3A%20%7B%0A%09%09%09%09%09%22type%22%3A%20%22plain_text%22%2C%0A%09%09%09%09%09%22text%22%3A%20%22Select%20a%20date%22%0A%09%09%09%09%7D%0A%09%09%09%7D%2C%0A%09%09%09%7B%0A%09%09%09%09%22type%22%3A%20%22overflow%22%2C%0A%09%09%09%09%22options%22%3A%20%5B%0A%09%09%09%09%09%7B%0A%09%09%09%09%09%09%22text%22%3A%20%7B%0A%09%09%09%09%09%09%09%22type%22%3A%20%22plain_text%22%2C%0A%09%09%09%09%09%09%09%22text%22%3A%20%22*this%20is%20plain_text%20text*%22%0A%09%09%09%09%09%09%7D%2C%0A%09%09%09%09%09%09%22value%22%3A%20%22value-0%22%0A%09%09%09%09%09%7D%2C%0A%09%09%09%09%09%7B%0A%09%09%09%09%09%09%22text%22%3A%20%7B%0A%09%09%09%09%09%09%09%22type%22%3A%20%22plain_text%22%2C%0A%09%09%09%09%09%09%09%22text%22%3A%20%22*this%20is%20plain_text%20text*%22%0A%09%09%09%09%09%09%7D%2C%0A%09%09%09%09%09%09%22value%22%3A%20%22value-1%22%0A%09%09%09%09%09%7D%2C%0A%09%09%09%09%09%7B%0A%09%09%09%09%09%09%22text%22%3A%20%7B%0A%09%09%09%09%09%09%09%22type%22%3A%20%22plain_text%22%2C%0A%09%09%09%09%09%09%09%22text%22%3A%20%22*this%20is%20plain_text%20text*%22%0A%09%09%09%09%09%09%7D%2C%0A%09%09%09%09%09%09%22value%22%3A%20%22value-2%22%0A%09%09%09%09%09%7D%2C%0A%09%09%09%09%09%7B%0A%09%09%09%09%09%09%22text%22%3A%20%7B%0A%09%09%09%09%09%09%09%22type%22%3A%20%22plain_text%22%2C%0A%09%09%09%09%09%09%09%22text%22%3A%20%22*this%20is%20plain_text%20text*%22%0A%09%09%09%09%09%09%7D%2C%0A%09%09%09%09%09%09%22value%22%3A%20%22value-3%22%0A%09%09%09%09%09%7D%2C%0A%09%09%09%09%09%7B%0A%09%09%09%09%09%09%22text%22%3A%20%7B%0A%09%09%09%09%09%09%09%22type%22%3A%20%22plain_text%22%2C%0A%09%09%09%09%09%09%09%22text%22%3A%20%22*this%20is%20plain_text%20text*%22%0A%09%09%09%09%09%09%7D%2C%0A%09%09%09%09%09%09%22value%22%3A%20%22value-4%22%0A%09%09%09%09%09%7D%0A%09%09%09%09%5D%2C%0A%09%09%09%09%22action_id%22%3A%20%22overflow%22%0A%09%09%09%7D%2C%0A%09%09%09%7B%0A%09%09%09%09%22type%22%3A%20%22button%22%2C%0A%09%09%09%09%22text%22%3A%20%7B%0A%09%09%09%09%09%22type%22%3A%20%22plain_text%22%2C%0A%09%09%09%09%09%22text%22%3A%20%22Click%20Me%22%0A%09%09%09%09%7D%2C%0A%09%09%09%09%22value%22%3A%20%22click_me_123%22%2C%0A%09%09%09%09%22action_id%22%3A%20%22button%22%0A%09%09%09%7D%0A%09%09%5D%0A%09%7D%0A%5D))
     * ```json
     *{
     *   "type": "actions",
     *   "block_id": "actionblock789",
     *   "elements": [
     *     {
     *       "type": "datepicker",
     *       "action_id": "datepicker123",
     *       "initial_date": "1990-04-28",
     *       "placeholder": {
     *         "type": "plain_text",
     *         "text": "Select a date"
     *       }
     *     },
     *     {
     *       "type": "overflow",
     *       "options": [
     *         {
     *           "text": {
     *             "type": "plain_text",
     *             "text": "*this is plain_text text*"
     *           },
     *           "value": "value-0"
     *         },
     *         {
     *           "text": {
     *             "type": "plain_text",
     *             "text": "*this is plain_text text*"
     *           },
     *           "value": "value-1"
     *         },
     *         {
     *           "text": {
     *             "type": "plain_text",
     *             "text": "*this is plain_text text*"
     *           },
     *           "value": "value-2"
     *         },
     *         {
     *           "text": {
     *             "type": "plain_text",
     *             "text": "*this is plain_text text*"
     *           },
     *           "value": "value-3"
     *         },
     *         {
     *           "text": {
     *             "type": "plain_text",
     *             "text": "*this is plain_text text*"
     *           },
     *           "value": "value-4"
     *         }
     *       ],
     *       "action_id": "overflow"
     *     },
     *     {
     *       "type": "button",
     *       "text": {
     *         "type": "plain_text",
     *         "text": "Click Me"
     *       },
     *       "value": "click_me_123",
     *       "action_id": "button"
     *     }
     *   ]
     * }
     * ```
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
     * Example ([view this in Block Kit Builder](https://api.slack.com/tools/block-kit-builder?blocks=%5B%0A%09%7B%0A%09%09%22type%22%3A%20%22context%22%2C%0A%09%09%22elements%22%3A%20%5B%0A%09%09%09%7B%0A%09%09%09%09%22type%22%3A%20%22image%22%2C%0A%09%09%09%09%22image_url%22%3A%20%22https%3A%2F%2Fimage.freepik.com%2Ffree-photo%2Fred-drawing-pin_1156-445.jpg%22%2C%0A%09%09%09%09%22alt_text%22%3A%20%22images%22%0A%09%09%09%7D%2C%0A%09%09%09%7B%0A%09%09%09%09%22type%22%3A%20%22mrkdwn%22%2C%0A%09%09%09%09%22text%22%3A%20%22Location%3A%20*Dogpatch*%22%0A%09%09%09%7D%0A%09%09%5D%0A%09%7D%0A%5D)):
     * ```json
     * {
     *   "type": "context",
     *   "elements": [
     *     {
     *       "type": "image",
     *       "image_url": "https://image.freepik.com/free-photo/red-drawing-pin_1156-445.jpg",
     *       "alt_text": "images"
     *     },
     *     {
     *       "type": "mrkdwn",
     *       "text": "Location: **Dogpatch**"
     *     }
     *   ]
     * }
     * ```
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

    /**
     * Displays a [remote file](https://api.slack.com/messaging/files#remote).
     * You can't add this block to app surfaces directly, but it will show up when
     * [retrieving messages](https://api.slack.com/messaging/retrieving) that contain remote files.
     * If you want to add remote files to messages, [follow the guide](https://api.slack.com/messaging/files#remote).
     *
     * Example:
     * ```json
     * {
     *   "type": "file",
     *   "external_id": "ABCD1",
     *   "source": "remote",
     * }
     * ```
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
     *
     * Example ([view this in Block Kit Builder](https://app.slack.com/block-kit-builder/?_gl=1*yspqej*_gcl_au*MTI4ODM0OTk1NS4xNzExMTc3MTY0#%7B%22type%22:%22home%22,%22blocks%22:%5B%7B%22type%22:%22header%22,%22text%22:%7B%22type%22:%22plain_text%22,%22text%22:%22Budget%20Performance%22%7D%7D,%7B%22type%22:%22divider%22%7D,%7B%22type%22:%22section%22,%22fields%22:%5B%7B%22type%22:%22mrkdwn%22,%22text%22:%22*Current%20Quarter*%5CnBudget:%20$18,000%20(ends%20in%2053%20days)%5CnSpend:%20$4,289.70%5CnRemain:%20$13,710.30%22%7D,%7B%22type%22:%22mrkdwn%22,%22text%22:%22*Top%20Expense%20Categories*%5Cn:airplane:%20Flights%20%C2%B7%2030%25%5Cn:taxi:%20Taxi%20/%20Uber%20/%20Lyft%20%C2%B7%2024%25%20%5Cn:knife_fork_plate:%20Client%20lunch%20/%20meetings%20%C2%B7%2018%25%22%7D%5D%7D,%7B%22type%22:%22context%22,%22elements%22:%5B%7B%22type%22:%22image%22,%22image_url%22:%22https://api.slack.com/img/blocks/bkb_template_images/placeholder.png%22,%22alt_text%22:%22placeholder%22%7D%5D%7D,%7B%22type%22:%22header%22,%22text%22:%7B%22type%22:%22plain_text%22,%22text%22:%22Expenses%20Awaiting%20Your%20Approval%22%7D%7D,%7B%22type%22:%22divider%22%7D,%7B%22type%22:%22context%22,%22elements%22:%5B%7B%22type%22:%22mrkdwn%22,%22text%22:%22Submitted%20by%22%7D,%7B%22type%22:%22image%22,%22image_url%22:%22https://api.slack.com/img/blocks/bkb_template_images/profile_3.png%22,%22alt_text%22:%22Dwight%20Schrute%22%7D,%7B%22type%22:%22mrkdwn%22,%22text%22:%22*Dwight%20Schrute*%22%7D%5D%7D,%7B%22type%22:%22section%22,%22text%22:%7B%22type%22:%22mrkdwn%22,%22text%22:%22*Team%20Lunch%20(Internal)*%5CnCost:%20*$85.50USD*%5CnDate:%20*10/16/2019*%5CnService%20Provider:%20*Honest%20Sandwiches*%20%20%5CnExpense%20no.%20*%3Cfakelink.toUrl.com%7C#1797PD%3E*%22%7D,%22accessory%22:%7B%22type%22:%22image%22,%22image_url%22:%22https://api.slack.com/img/blocks/bkb_template_images/creditcard.png%22,%22alt_text%22:%22credit%20card%22%7D%7D,%7B%22type%22:%22actions%22,%22elements%22:%5B%7B%22type%22:%22button%22,%22text%22:%7B%22type%22:%22plain_text%22,%22text%22:%22Approve%22,%22emoji%22:true%7D,%22style%22:%22primary%22,%22value%22:%22approve%22%7D,%7B%22type%22:%22button%22,%22text%22:%7B%22type%22:%22plain_text%22,%22text%22:%22Decline%22,%22emoji%22:true%7D,%22style%22:%22danger%22,%22value%22:%22decline%22%7D,%7B%22type%22:%22button%22,%22text%22:%7B%22type%22:%22plain_text%22,%22text%22:%22View%20Details%22,%22emoji%22:true%7D,%22value%22:%22details%22%7D%5D%7D,%7B%22type%22:%22divider%22%7D,%7B%22type%22:%22context%22,%22elements%22:%5B%7B%22type%22:%22mrkdwn%22,%22text%22:%22Submitted%20by%22%7D,%7B%22type%22:%22image%22,%22image_url%22:%22https://api.slack.com/img/blocks/bkb_template_images/profile_2.png%22,%22alt_text%22:%22Pam%20Beasely%22%7D,%7B%22type%22:%22mrkdwn%22,%22text%22:%22*Pam%20Beasely*%22%7D%5D%7D,%7B%22type%22:%22section%22,%22text%22:%7B%22type%22:%22mrkdwn%22,%22text%22:%22*Flights%20to%20New%20York*%5CnCost:%20*$520.78USD*%5CnDate:%20*10/18/2019*%5CnService%20Provider:%20*Delta%20Airways*%5CnExpense%20no.%20*%3Cfakelink.toUrl.com%7C#1803PD%3E*%22%7D,%22accessory%22:%7B%22type%22:%22image%22,%22image_url%22:%22https://api.slack.com/img/blocks/bkb_template_images/plane.png%22,%22alt_text%22:%22plane%22%7D%7D,%7B%22type%22:%22actions%22,%22elements%22:%5B%7B%22type%22:%22button%22,%22text%22:%7B%22type%22:%22plain_text%22,%22text%22:%22Approve%22,%22emoji%22:true%7D,%22style%22:%22primary%22,%22value%22:%22approve%22%7D,%7B%22type%22:%22button%22,%22text%22:%7B%22type%22:%22plain_text%22,%22text%22:%22Decline%22,%22emoji%22:true%7D,%22style%22:%22danger%22,%22value%22:%22decline%22%7D,%7B%22type%22:%22button%22,%22text%22:%7B%22type%22:%22plain_text%22,%22text%22:%22View%20Details%22,%22emoji%22:true%7D,%22value%22:%22details%22%7D%5D%7D%5D%7D)):
     * ```json
     * {
     *   "type": "header",
     *   "text": {
     *     "type": "plain_text",
     *     "text": "Budget Performance"
     *   }
     * }
     * ```
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
     *
     * Examples:
     * - An image block using `image_url` ([view this in Block Kit Builder](https://api.slack.com/tools/block-kit-builder?blocks=%5B%0A%20%20%20%20%7B%0A%20%20%20%20%20%20%22type%22%3A%20%22image%22%2C%0A%20%20%20%20%20%20%22title%22%3A%20%7B%0A%20%20%20%20%20%20%20%20%22type%22%3A%20%22plain_text%22%2C%0A%20%20%20%20%20%20%20%20%22text%22%3A%20%22Please%20enjoy%20this%20photo%20of%20a%20kitten%22%0A%20%20%20%20%20%20%7D%2C%0A%20%20%20%20%20%20%22block_id%22%3A%20%22image4%22%2C%0A%20%20%20%20%20%20%22image_url%22%3A%20%22http%3A%2F%2Fplacekitten.com%2F500%2F500%22%2C%0A%20%20%20%20%20%20%22alt_text%22%3A%20%22An%20incredibly%20cute%20kitten.%22%0A%20%20%20%20%7D%0A%5D))
     * ```json
     * {
     *   "type": "image",
     *   "title": {
     *     "type": "plain_text",
     *     "text": "Please enjoy this photo of a kitten"
     *   },
     *   "block_id": "image4",
     *   "image_url": "http://placekitten.com/500/500",
     *   "alt_text": "An incredibly cute kitten."
     * }
     * ```
     * - An image block using `slack_file` with a `url`
     * ```json
     * {
     *   "type": "image",
     *   "title": {
     *     "type": "plain_text",
     *     "text": "This image block contains a reference to a Slack image file."
     *   },
     *   "block_id": "image4",
     *   "slack_file": {
     *     "url": "https://files.slack.com/files-pri/T0123456-F0123456/xyz.png"
     *   },
     *   "alt_text": "Slack file object."
     * }
     * ```
     * - An image block using `slack_file` with a `id`:
     * ```json
     * {
     *   "type": "image",
     *   "title": {
     *     "type": "plain_text",
     *     "text": "This image block contains a reference to a Slack image file."
     *   },
     *   "block_id": "image4",
     *   "slack_file": {
     *     "id": "F0123456",
     *   },
     *   "alt_text": "Slack file object."
     * }
     * ```
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
     * Example:
     * - An input block containing a [CompositionObject.Text.PlainText]) ([view this in Block Kit Builder](https://app.slack.com/block-kit-builder/?_gl=1*dgipho*_gcl_au*MTI4ODM0OTk1NS4xNzExMTc3MTY0#%7B%22title%22:%7B%22type%22:%22plain_text%22,%22text%22:%22Add%20info%20to%20feedback%22,%22emoji%22:true%7D,%22submit%22:%7B%22type%22:%22plain_text%22,%22text%22:%22Save%22,%22emoji%22:true%7D,%22type%22:%22modal%22,%22blocks%22:%5B%7B%22type%22:%22input%22,%22element%22:%7B%22type%22:%22plain_text_input%22%7D,%22label%22:%7B%22type%22:%22plain_text%22,%22text%22:%22Label%22,%22emoji%22:true%7D%7D%5D%7D))
     * ```json
     * {
     *   "type": "input",
     *   "element": {
     *     "type": "plain_text_input"
     *   },
     *   "label": {
     *     "type": "plain_text",
     *     "text": "Label",
     *     "emoji": true
     *   }
     * }
     * ```
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

    /**
     * Displays text, possibly alongside block elements.
     * A section can be used as a text block, in combination with text fields, or side-by-side with certain [Element]s.
     */
    sealed class Section(
        /**
         * A unique identifier for a block. If not specified, a block_id will be generated by the Slack API.
         * You can use this [blockID] when you receive an interaction payload to identify the source of the action.
         * Maximum length for this field is 255 characters. [blockID] should be unique for each message and each iteration
         * of a message. If a message is updated, use a new [blockID].
         */
        @SerialName("block_id")
        override val blockID: BlockID?
    ) : Block(type = Type.SECTION) {
        /**
         * Example:
         * ```json
         * {
         *   "type": "section",
         *   "text": {
         *     "type": "mrkdwn",
         *     "text": "A message *with some bold text* and _some italicized text_."
         *   }
         * }
         * [View this block in Block Kit Builder](https://api.slack.com/tools/block-kit-builder?blocks=%5B%0A%09%7B%0A%09%09%22type%22%3A%20%22section%22%2C%0A%09%09%22text%22%3A%20%7B%0A%20%20%20%20%20%20%20%20%20%20%20%20%22type%22%3A%20%22mrkdwn%22%2C%0A%20%20%20%20%20%20%20%20%20%20%20%20%22text%22%3A%20%22A%20message%20*with%20some%20bold%20text*%20and%20_some%20italicized%20text_.%22%0A%20%20%20%20%20%20%20%20%7D%2C%0A%09%09%22block_id%22%3A%20%22text1%22%0A%09%7D%0A%5D)
         * ```
         */
        data class TextOnlySection(
            /**
             * One of the compatible [Element] objects. Be sure to confirm the desired element works with section.
             */
            val accessory: Element,
            /**
             * The text for the block, in the form of a [CompositionObject.Text] text object.
             * Minimum length for the text in this field is 1 and maximum length is 3000 characters.
             */
            val text: CompositionObject.Text
        )

        /**
         * Examples:
         * - A section block containing text fields ([view this in Block Kit Builder](https://api.slack.com/tools/block-kit-builder?blocks=%5B%0A%09%7B%0A%09%09%22type%22%3A%20%22section%22%2C%0A%09%09%22text%22%3A%20%7B%0A%09%09%09%22text%22%3A%20%22A%20message%20*with%20some%20bold%20text*%20and%20_some%20italicized%20text_.%22%2C%0A%09%09%09%22type%22%3A%20%22mrkdwn%22%0A%09%09%7D%2C%0A%09%09%22fields%22%3A%20%5B%0A%09%09%09%7B%0A%09%09%09%09%22type%22%3A%20%22mrkdwn%22%2C%0A%09%09%09%09%22text%22%3A%20%22*Priority*%22%0A%09%09%09%7D%2C%0A%09%09%09%7B%0A%09%09%09%09%22type%22%3A%20%22mrkdwn%22%2C%0A%09%09%09%09%22text%22%3A%20%22*Type*%22%0A%09%09%09%7D%2C%0A%09%09%09%7B%0A%09%09%09%09%22type%22%3A%20%22plain_text%22%2C%0A%09%09%09%09%22text%22%3A%20%22High%22%0A%09%09%09%7D%2C%0A%09%09%09%7B%0A%09%09%09%09%22type%22%3A%20%22plain_text%22%2C%0A%09%09%09%09%22text%22%3A%20%22String%22%0A%09%09%09%7D%0A%09%09%5D%0A%09%7D%0A%5D)):
         * ```json
         * {
         *   "type": "section",
         *   "text": {
         *     "text": "A message *with some bold text* and _some italicized text_.",
         *     "type": "mrkdwn"
         *   },
         *   "fields": [
         *     {
         *       "type": "mrkdwn",
         *       "text": "High"
         *     },
         *     {
         *       "type": "plain_text",
         *       "emoji": true,
         *       "text": "String"
         *     }
         *   ]
         * }
         * ```
         * - A section block containing a date picker element ([view this in Block Kit Builder](https://api.slack.com/tools/block-kit-builder?blocks=%5B%0A%09%7B%0A%20%20%22type%22%3A%20%22section%22%2C%0A%20%20%22text%22%3A%20%7B%0A%20%20%20%20%22text%22%3A%20%22*Sally*%20has%20requested%20you%20set%20the%20deadline%20for%20the%20Nano%20launch%20project%22%2C%0A%20%20%20%20%22type%22%3A%20%22mrkdwn%22%0A%20%20%7D%2C%0A%20%20%22accessory%22%3A%20%7B%0A%20%20%20%20%22type%22%3A%20%22datepicker%22%0A%20%20%7D%0A%7D%0A%5D)):
         * ```json
         * {
         *   "type": "section",
         *   "text": {
         *     "text": "*Sally* has requested you set the deadline for the Nano launch project",
         *     "type": "mrkdwn"
         *   },
         *   "accessory": {
         *     "type": "datepicker",
         *     "action_id": "datepicker123",
         *     "initial_date": "1990-04-28",
         *     "placeholder": {
         *       "type": "plain_text",
         *       "text": "Select a date"
         *     }
         *   }
         * }
         *
         * ```
         */
        data class FieldsSection(
            /**
             * A list of text objects.
             * Any text objects included with fields will be rendered in a compact format that allows for 2 columns of
             * side-by-side text.
             * Maximum number of items is 10.
             * Maximum length for the text in each item is 2000 characters.
             * [Click here for an example](https://api.slack.com/tools/block-kit-builder?blocks=%5B%0A%09%7B%0A%09%09%22type%22%3A%20%22section%22%2C%0A%09%09%22text%22%3A%20%7B%0A%09%09%09%22text%22%3A%20%22A%20message%20*with%20some%20bold%20text*%20and%20_some%20italicized%20text_.%22%2C%0A%09%09%09%22type%22%3A%20%22mrkdwn%22%0A%09%09%7D%2C%0A%09%09%22fields%22%3A%20%5B%0A%09%09%09%7B%0A%09%09%09%09%22type%22%3A%20%22mrkdwn%22%2C%0A%09%09%09%09%22text%22%3A%20%22*Priority*%22%0A%09%09%09%7D%2C%0A%09%09%09%7B%0A%09%09%09%09%22type%22%3A%20%22mrkdwn%22%2C%0A%09%09%09%09%22text%22%3A%20%22*Type*%22%0A%09%09%09%7D%2C%0A%09%09%09%7B%0A%09%09%09%09%22type%22%3A%20%22plain_text%22%2C%0A%09%09%09%09%22text%22%3A%20%22High%22%0A%09%09%09%7D%2C%0A%09%09%09%7B%0A%09%09%09%09%22type%22%3A%20%22plain_text%22%2C%0A%09%09%09%09%22text%22%3A%20%22String%22%0A%09%09%09%7D%0A%09%09%5D%0A%09%7D%0A%5D).
             */
            val fields: List<CompositionObject.Text>,
            /**
             * The text for the block, in the form of a [CompositionObject.Text] text object.
             * Minimum length for the text in this field is 1 and maximum length is 3000 characters.
             */
            val text: CompositionObject.Text?
        )
    }

    /**
     * Displays an embedded video player.
     * A video block is designed to embed videos in all app surfaces (e.g. link unfurls, messages, modals, App Home) —
     * anywhere you can put blocks! To use the video block within your app, you must have the
     * [links.embed:write](https://api.slack.com/scopes/links.embed:write) scope.
     * The metadata received in the block payload will be used to construct the description, provider, and title of the
     * video in all clients. Developers have the flexibility to leave non-mandatory fields null and use other blocks to
     * format this content.
     *
     * **[Requirements:](https://api.slack.com/reference/block-kit/blocks#video_requirements)**
     * - Video blocks can only be posted by apps; users are not allowed to post embedded videos directly from Block Kit
     * Builder.
     * - Your app must have the [links.embed:write](https://api.slack.com/scopes/links.embed:write) scope for both user
     * and bot tokens.
     * - `video_url` has to be included in the
     * [unfurl domains](https://api.slack.com/reference/messaging/link-unfurling#configuring_domains) specified in your
     * app.
     * - `video_url` should be publicly accessible, unless the app relies on information received from the
     * [Events API](https://api.slack.com/apis/connections/events-api) payloads to make a decision on whether the
     * viewer(s) of the content should have access. If so, the service could create a unique URL accessible only via
     * Slack.
     * - `video_url` must be compatible with an embeddable iFrame.
     * - `video_url` must return a 2xx code OR 3xx with less than 5 redirects and an eventual 2xx.
     * - `video_url` must not point to any Slack-related domain.
     *
     * **[Constraints:](https://api.slack.com/reference/block-kit/blocks#video__constraints)**
     * - Embeddable video players only (audio-only permitted)
     * - Navigation, scrolling and overlays are not allowed within the iFrame.
     * - Interactivity (e.g. likes, comments, and reactions) are allowed within your player but shouldn't completely
     * overlay or navigate away from the content being embedded. These interactions will be anonymous since no user
     * data is transferred to the embedded view.
     *
     * Example:
     * ```json
     * {
     *   "blocks": [
     *     {
     *       "type": "section",
     *       "text": {
     *         "type": "plain_text",
     *         "text": "I think it's super cool",
     *         "emoji": true
     *       }
     *     },
     *     {
     *       "type": "video",
     *       "title": {
     *         "type": "plain_text",
     *         "text": "How to use Slack.",
     *         "emoji": true
     *       },
     *       "title_url": "https://www.youtube.com/watch?v=RRxQQxiM7AA",
     *       "description": {
     *         "type": "plain_text",
     *         "text": "Slack is a nifty way to communicate with your team.",
     *         "emoji": true
     *       },
     *       "video_url": "https://www.youtube.com/embed/RRxQQxiM7AA?feature=oembed&autoplay=1",
     *       "alt_text": "How to use Slack?",
     *       "thumbnail_url": "https://i.ytimg.com/vi/RRxQQxiM7AA/hqdefault.jpg",
     *       "author_name": "Arcado Buendia",
     *       "provider_name": "YouTube",
     *       "provider_icon_url": "https://a.slack-edge.com/80588/img/unfurl_icons/youtube.png"
     *     }
     *   ]
     * }
     * ```
     */
    data class Video(
        /**
         * A unique identifier for a block. If not specified, a block_id will be generated by the Slack API.
         * You can use this [blockID] when you receive an interaction payload to identify the source of the action.
         * Maximum length for this field is 255 characters. [blockID] should be unique for each message and each iteration
         * of a message. If a message is updated, use a new [blockID].
         */
        @SerialName("block_id")
        override val blockID: BlockID?,
        /**
         * A tooltip for the video. Required for accessibility.
         */
        @SerialName("alt_text")
        val altText: String,
        /**
         * Author name to be displayed. Must be less than 50 characters.
         */
        @SerialName("author_name")
        val authorName: String?,
        /**
         * Description for video in the form of a [CompositionObject.Text.PlainText] object.
         * `text` within must be less than 200 characters.
         */
        val description: CompositionObject.Text.PlainText?,
        /**
         * Icon for the video provider, e.g. YouTube icon.
         */
        @SerialName("provider_icon_url")
        val providerIconUrl: URL?,
        /**
         * The originating application or domain of the video, e.g. YouTube.
         */
        @SerialName("provider_name")
        val providerName: String?,
        /**
         * The thumbnail image URL.
         */
        @SerialName("thumbnail_url")
        val thumbnailUrl: URL,
        /**
         * Video title in the form of a [CompositionObject.Text.PlainText].
         * `text` within must be less than 200 characters.
         */
        val title: CompositionObject.Text.PlainText,
        /**
         * Hyperlink for the title text.
         * Must correspond to the non-embeddable URL for the video.
         * Must go to an HTTPS URL.
         */
        @SerialName("title_url")
        val titleUrl: URL?,
        /**
         * The URL to be embedded. Must match any existing
         * [unfurl domains](https://api.slack.com/reference/messaging/link-unfurling#configuring_domains) within the app
         * and point to an HTTPS URL.
         */
        @SerialName("video_url")
        val videoUrl: URL
    ) : Block(type = Type.VIDEO)
}
