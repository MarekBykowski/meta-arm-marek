# meta-arm-marek

Yocto layer for ARM FVP-Base development and training.

## Dependencies

| Layer | Repository | Tag |
|---|---|---|
| openembedded-core | https://git.openembedded.org/openembedded-core | yocto-5.3.3 |
| meta-yocto | https://git.yoctoproject.org/meta-yocto | yocto-5.3.3 |
| meta-arm | https://git.yoctoproject.org/meta-arm | yocto-5.3 |

## Setup and build

```bash
mkdir yocto-new && cd yocto-new
# Copy kas/fvp-base.yml from this repo into yocto-new
kas checkout --build-dir arm-aem-build fvp-base.yml
source layers/openembedded-core/oe-init-build-env arm-aem-build
bitbake core-image-minimal
```

## Running the FVP

```bash
./layers/meta-arm-marek/scripts/run.sh
./layers/meta-arm-marek/scripts/run.sh armds  # with Arm DS connection
```

## Maintainer

Marek Bykowski <marek.bykowski@gmail.com>
