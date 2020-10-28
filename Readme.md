# League of Legends Champion Mastery Discord Bot

<div align="center">
    <br><br>
    <a href="https://github.com/lukasschachner/masterypointbot/releases"><img height="28" src="https://img.shields.io/github/tag/zekroTJA/shinpuru.svg?style=for-the-badge"/></a>&nbsp;
    <a href="https://hub.docker.com/r/lukasschachner/masterypointbot"><img alt="Docker Image" src="https://img.shields.io/docker/cloud/automated/zekro/shinpuru.svg?color=cyan&logo=docker&logoColor=cyan&style=for-the-badge"></a>&nbsp;
    <strong>CI Status:</strong> <br>
    <img alt="GitHub" src="https://img.shields.io/github/license/lukasschachner/masterypointbot?style=for-the-badge">
    <img alt="CIBuild" src="https://img.shields.io/github/workflow/status/lukasschachner/masterypointbot/Java%20CI%20with%20Maven?style=for-the-badge">
    <img alt="CIBuild" src="https://img.shields.io/github/workflow/status/lukasschachner/masterypointbot/Docker%20Image%20CI?style=for-the-badge">
<br>
</div>


## CI Status
![Build](https://img.shields.io/github/workflow/status/lukasschachner/masterypointbot/Java%20CI%20with%20Maven?style=for-the-badge)<br/>


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
