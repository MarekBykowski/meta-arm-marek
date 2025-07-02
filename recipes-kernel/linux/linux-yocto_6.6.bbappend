FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}_6.6:"

# mb: Adding my kernel repo and autorev (take the last commit on the branch)
SRC_URI:fvp-base = "git://github.com/MarekBykowski/linux-yocto.git;name=machine;branch=${KBRANCH};protocol=https \
		    git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-6.6;destsuffix=${KMETA};protocol=https"
#KBRANCH:fvp-base = "aem-forked-off-v6.6/standard/base"
KBRANCH:fvp-base = "extender_on_aem-forked-off-v6.6/standard/base"
SRCREV_machine:fvp-base = "${AUTOREV}"

#SRC_URI:fvp-base += " \
#	file://0001-Updates.patch \
#	"
