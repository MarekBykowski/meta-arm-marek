FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# mb: Adding my kernel repo and autorev (take the last commit on the branch)
SRC_URI:fvp-base = "git://github.com/MarekBykowski/linux-yocto.git;name=machine;branch=${KBRANCH};protocol=https \
		    git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-6.6;destsuffix=${KMETA};protocol=https"
KBRANCH:fvp-base = "extender"
SRCREV_machine:fvp-base = "${AUTOREV}"
