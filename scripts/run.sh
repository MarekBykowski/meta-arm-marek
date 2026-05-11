#!/bin/bash

SCRIPT_DIR=$(dirname "$(realpath "$BASH_SOURCE")")
BUILD_DIR=$(realpath "$SCRIPT_DIR/../../../build")
RUNFVP="$SCRIPT_DIR/../../../layers/meta-arm/scripts/runfvp"
FVPCONF="$BUILD_DIR/tmp/deploy/images/fvp-base/core-image-minimal-fvp-base.fvpconf"

pathadd() {
    if [ -d "$1" ] && [[ ":$PATH:" != *":$1:"* ]]; then
        PATH="${PATH:+"$PATH:"}$1"
    fi
}
pathadd ~/Downloads/FVP_Base_RevC-2xAEMvA_11.29_27_Linux64/Base_RevC_AEMvA_pkg/models/Linux64_GCC-9.3

if [[ $1 == armds ]]; then
    "$RUNFVP" --verbose "$FVPCONF" -- --iris-server --iris-port 7101 --iris-allow-remote
else
    "$RUNFVP" --verbose "$FVPCONF"
fi
