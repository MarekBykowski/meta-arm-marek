FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI_U_BOOT = "git://github.com/MarekBykowski/u-boot.git;protocol=https"

SRC_URI += " \
	file://0001-comments-breakpoints.patch \
	file://config-logging.cfg \
	file://config-bootdelay.cfg \
	file://0001-Remove-branching-ot-itself.patch \
	   "

INHIBIT_PACKAGE_STRIP = "1"
