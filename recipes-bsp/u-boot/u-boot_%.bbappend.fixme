# u-boot board files: `board/armltd/vexpress64/`
# Kconfig: vexpress_fvp_defconfig

# Apply only for MACHINE=fvp-base
COMPATIBLE_MACHINE = "fvp-base"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "git://github.com/MarekBykowski/u-boot.git;protocol=https;branch=yocto-fvp-base"

SRC_URI += " \
	file://config-logging.cfg \
	file://config-bootdelay.cfg \
	   "
SRCREV = "${AUTOREV}"

INHIBIT_PACKAGE_STRIP = "1"
