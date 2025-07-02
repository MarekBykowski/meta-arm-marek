FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# SRC_URI_TRUSTED_FIRMWARE_A embeds into SRC_URI as follows
#    SRC_URI = "${SRC_URI_TRUSTED_FIRMWARE_A};name=tfa;branch=${SRCBRANCH};
# Change SRC_URI_TRUSTED_FIRMWARE_A to point to mine at github
SRC_URI_TRUSTED_FIRMWARE_A = "git://github.com/MarekBykowski/trusted-firmware-a.git;protocol=https"

# To change the branch SRCBRANCH and/or SHA1 commit SRCREV uncomment the below
#SRCREV_tfa = "569e16caad976a0684147da1ecc6333fd9b7f813"
#SRCBRANCH = "lts-v2.10.4-branch"

SRC_URI += " \
	file://0001-comments-breakpoints.patch \
	   "
