FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI_U_BOOT = "git://github.com/MarekBykowski/u-boot.git;protocol=https"

# .bb and/or .bbappend prepended pointed to the SHA1 below
# SRCREV = "e4b6ebd3de982ae7185dbf689a030e73fd06e0d2"
# We change it to `autorev` on our specific branch
SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/MarekBykowski/u-boot.git;branch=fvp-base-arm32"

SRC_URI:remove = " \
	file://0001-Add-vexpress_aemv8a_aarch32-variant.patch \
	file://0002-Revert-vexpress64-Enable-OF_CONTROL-and-OF_BOARD-for.patch \
	   "
