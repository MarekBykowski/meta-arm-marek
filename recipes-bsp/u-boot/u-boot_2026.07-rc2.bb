require recipes-bsp/u-boot/u-boot-common.inc
require recipes-bsp/u-boot/u-boot.inc

DEPENDS += "bc-native dtc-native gnutls-native python3-pyelftools-native"

#SRC_URI = "git://source.denx.de/u-boot/u-boot.git;protocol=https;branch=master"
#SRCREV = "${AUTOREV}"

#SRC_URI = "git://github.com/MarekBykowski/u-boot.git;protocol=https;branch=fvp-whinlatter,tag=v2026.07-rc2"
#SRCREV = "5732bd0f457b4c671e46574d64d4acb099c0f0a5"
SRC_URI = "git://github.com/MarekBykowski/u-boot.git;protocol=https;branch=branch-v2026.07-rc2"
SRCREV = "${AUTOREV}"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PV}:"

SRC_URI += " \
    file://config-logging.cfg \
    file://config-bootdelay.cfg \
    file://config-meminfo.cfg \
    "

COMPATIBLE_MACHINE = "fvp-base"
INHIBIT_PACKAGE_STRIP = "1"
