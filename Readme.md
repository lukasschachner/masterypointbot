
<div align="center">
    <h1>League of Legends Champion Mastery Discord Bot</h1>
    <br><br>
    <img alt="GitHub" src="https://img.shields.io/github/license/lukasschachner/masterypointbot?style=for-the-badge">
    <img alt="GitHub tag (latest by date)" src="https://img.shields.io/github/v/tag/lukasschachner/masterypointbot?label=version&style=for-the-badge"><br><br>
    <strong>CI Status:</strong> <br>
    <img alt="CIBuild" src="https://img.shields.io/github/workflow/status/lukasschachner/masterypointbot/Java%20CI%20with%20Maven?style=for-the-badge">
    <img alt="CIBuild" src="https://img.shields.io/github/workflow/status/lukasschachner/masterypointbot/Docker%20Image%20CI?style=for-the-badge">
    <br>
</div>

 a simple Discord bot to request stats about champion mastery via chat commands
 
 USAGE: 
 >general `>get \<your summoner name> \<server>` <br/>
 >example: `>get yomamma na`
 
 Deploy your own bot: <br/>
 - Simple version:
    > - Create a Discord bot application run the latest release from the release
    > - open a command line in the folder where you downloaded the bot
    > - run the app with `java -jar masterybot-1.0.0.jar <YOUR_BOT_TOKEN>`
 - Docker:
    > - run 
    >   `docker run -e BOT_TOKEN=<YOUR_BOT_TOKEN> lukasschachner/masterpointbot`
