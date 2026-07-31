# [SBW] Mini Auto Turret

Adds compact, tripod-mounted auto-sentry turrets, a form factor that doesn't
exist in the base SuperbWarfare mod (which only has large-scale turrets like
HPJ-11 or the laser tower). This mod fills that gap with small, lightweight
defense turrets, built as an addon for
[SuperbWarfare](https://modrinth.com/mod/superb-warfare) by Mercurows.

The first turret is an M60-based sentry for cheap early-game defense. More
turret types are planned for later, heavier progression.

Available for both NeoForge 1.21.1 and Forge 1.20.1.

## Requirements

**NeoForge 1.21.1**
- NeoForge 21.1.235+
- SuperbWarfare 0.8.9+
- Curios API
- GeckoLib

**Forge 1.20.1**
- Forge 47.4.10+
- SuperbWarfare 0.8.9+
- Curios API
- GeckoLib

**SuperbWarfare, Curios API, and GeckoLib are required for both versions.**
This mod does not work standalone.

## Features
- Compact tripod-mounted sentry turrets. Original models, not present in vanilla SuperbWarfare
- Automatic target acquisition and engagement using SuperbWarfare's AI aiming system
- Container-based deployment (place/pick up like other SuperbWarfare vehicles)
- Progression-based turret roadmap: a cheap M60 sentry early, heavier turret types planned for later
- Custom crafting recipes using SuperbWarfare parts

## Installation
1. Install the correct loader (NeoForge or Forge) matching the version you pick
2. Install [SuperbWarfare](https://modrinth.com/mod/superb-warfare) first
3. Install Curios API and GeckoLib
4. Drop this mod's jar into your `mods` folder

## Building from source
This repository has two branches, one per loader:
- `main` — NeoForge 1.21.1
- `1.20.1-forge` — Forge 1.20.1

Both depend on the SuperbWarfare jar as a local file dependency (see
`compileOnly files(...)` in `build.gradle`), it is not pulled from a Maven
repository, so it is not included in this repository.

To build from source:
1. Check out the branch matching the loader you want to build.
2. Download the matching SuperbWarfare 0.8.9 build from
   [Modrinth](https://modrinth.com/mod/superb-warfare) (NeoForge 1.21.1 or
   Forge 1.20.1, matching the branch).
3. Place the jar file in the `libs/` folder at the project root.
4. Run the Gradle build as usual.

## License
This mod's code is licensed under GPL-3.0 (see LICENSE), consistent with its
dependency on SuperbWarfare's GPL-3.0-licensed codebase
([source](https://github.com/Mercurows/SuperbWarfare)). The turret models and
textures are adapted from SuperbWarfare's existing M60 and TOW assets into
original compact designs, not standalone original artwork.

## Credits
Built on top of [SuperbWarfare](https://modrinth.com/mod/superb-warfare) by Mercurows.
Project scaffolding originally based on the NeoForged MDK template (MIT licensed).