FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

#lts-v2.10.4-branch
#SRC_URI_TRUSTED_FIRMWARE_A ?= "git://git.trustedfirmware.org/TF-A/trusted-firmware-a.git;protocol=https"
SRC_URI_TRUSTED_FIRMWARE_A = "git://github.com/MarekBykowski/trusted-firmware-a.git;protocol=https"
#SRC_URI = "${SRC_URI_TRUSTED_FIRMWARE_A};name=tfa;branch=${SRCBRANCH};
#SRCREV_tfa = "569e16caad976a0684147da1ecc6333fd9b7f813"
#SRCBRANCH = "lts-v2.10.4-branch"

SRC_URI += " \
	file://0001-comments-breakpoints.patch \
	   "
