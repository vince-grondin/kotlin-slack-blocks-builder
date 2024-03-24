package eth.rochsolid.slack.blocks.models.compositionobjects

/**
 * Defines a way to group options in a menu.
 *
 * The menu can be a [select menu](https://api.slack.com/reference/block-kit/block-elements#select)
 * or a [multi-select menu](https://api.slack.com/reference/block-kit/block-elements#multi_select).
 * An [OptionGroup] array can have a maximum number of 100 option groups with a maximum of 100 options.
 *
 * Example ([view in Block Kit Builder](https://api.slack.com/tools/block-kit-builder?mode=message&blocks=%5B%7B%22type%22%3A%22section%22%2C%22text%22%3A%7B%22type%22%3A%22mrkdwn%22%2C%22text%22%3A%22%3Amag%3A%20Search%20results%20for%20*Cata*%22%7D%7D%2C%7B%22type%22%3A%22divider%22%7D%2C%7B%22type%22%3A%22section%22%2C%22text%22%3A%7B%22type%22%3A%22mrkdwn%22%2C%22text%22%3A%22*%3CfakeLink.toYourApp.com%7CUse%20Case%20Catalogue%3E*%5CnUse%20Case%20Catalogue%20for%20the%20following%20departments%2Froles...%22%7D%2C%22accessory%22%3A%7B%22type%22%3A%22static_select%22%2C%22placeholder%22%3A%7B%22type%22%3A%22plain_text%22%2C%22emoji%22%3Atrue%2C%22text%22%3A%22Manage%22%7D%2C%22option_groups%22%3A%5B%7B%22label%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22Group%201%22%7D%2C%22options%22%3A%5B%7B%22text%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22*this%20is%20plain_text%20text*%22%7D%2C%22value%22%3A%22value-0%22%7D%2C%7B%22text%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22*this%20is%20plain_text%20text*%22%7D%2C%22value%22%3A%22value-1%22%7D%2C%7B%22text%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22*this%20is%20plain_text%20text*%22%7D%2C%22value%22%3A%22value-2%22%7D%5D%7D%2C%7B%22label%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22Group%202%22%7D%2C%22options%22%3A%5B%7B%22text%22%3A%7B%22type%22%3A%22plain_text%22%2C%22text%22%3A%22*this%20is%20plain_text%20text*%22%7D%2C%22value%22%3A%22value-3%22%7D%5D%7D%5D%7D%7D%5D)):
 * ```json
 * "option_groups": [
 *     {
 *         "label": {
 *             "type": "plain_text",
 *             "text": "Group 1"
 *         },
 *         "options": [
 *             {
 *                 "text": {
 *                     "type": "plain_text",
 *                     "text": "*this is plain_text text*"
 *                 },
 *                 "value": "value-0"
 *             },
 *             {
 *                 "text": {
 *                     "type": "plain_text",
 *                     "text": "*this is plain_text text*"
 *                 },
 *                 "value": "value-1"
 *             },
 *             {
 *                 "text": {
 *                     "type": "plain_text",
 *                     "text": "*this is plain_text text*"
 *                 },
 *                 "value": "value-2"
 *             }
 *         ]
 *     },
 *     {
 *         "label": {
 *             "type": "plain_text",
 *             "text": "Group 2"
 *         },
 *         "options": [
 *             {
 *                 "text": {
 *                     "type": "plain_text",
 *                     "text": "*this is plain_text text*"
 *                 },
 *                 "value": "value-3"
 *             }
 *         ]
 *     }
 * ]
 * ```
 */
data class OptionGroup(
    /**
     * A [Text.PlainText] text object that defines the label shown above this group of options.
     * Maximum length for the `text` in this field is 75 characters.
     */
    val label: Text.PlainText,
    /**
     * A list of [Option] objects that belong to this specific group.
     * Maximum of 100 items.
     */
    val options: List<Option>
)
