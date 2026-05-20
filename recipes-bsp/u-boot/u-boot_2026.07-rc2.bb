require recipes-bsp/u-boot/u-boot-common.inc
require recipes-bsp/u-boot/u-boot.inc

DEPENDS += "bc-native dtc-native gnutls-native python3-pyelftools-native"

SRC_URI = "git://github.com/MarekBykowski/u-boot.git;protocol=https;branch=master;tag=v2026.07-rc2"
SRCREV = "5732bd0f457b4c671e46574d64d4acb099c0f0a5"
#SRC_URI = "git://source.denx.de/u-boot/u-boot.git;protocol=https;branch=master"
#SRCREV = "${AUTOREV}"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PV}:"
# Patches 0001-0003 from meta-arm-bsp/u-boot-fvp-base.inc don't apply to master:
# - 0001 (DM_RNG) is already merged upstream
# - 0002 (SYSRESET): reset_cpu removal already in master; Kconfig part consolidated below
# - 0003 (ARM64_CRC32): consolidated below
#SRC_URI:remove = " \
#    file://0001-vexpress64-Set-the-DM_RNG-property.patch \
#    file://0002-vexpress64-Select-PSCI-RESET-by-default.patch \
#    file://0003-vexpress64-Imply-CONFIG_ARM64_CRC32-by-default.patch \
#    "

SRC_URI += " \
    file://config-logging.cfg \
    file://config-bootdelay.cfg \
    "

COMPATIBLE_MACHINE = "fvp-base"
INHIBIT_PACKAGE_STRIP = "1"
