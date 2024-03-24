package eth.rochsolid.slack.blocks.models.blocks

import eth.rochsolid.slack.blocks.models.elements.Element
import kotlinx.serialization.SerialName


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
