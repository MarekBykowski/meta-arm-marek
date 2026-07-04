KBRANCH ?= "marek_learning"

require recipes-kernel/linux/linux-yocto.inc

# Marek's learning kernel fork
SRC_URI = "git://github.com/MarekBykowski/linux_kernel_4_19.git;protocol=https;name=machine;branch=${KBRANCH} \
           git://git.yoctoproject.org/yocto-kernel-cache;protocol=https;type=kmeta;name=meta;branch=yocto-4.19;destsuffix=${KMETA}"
SRCREV_machine = "${AUTOREV}"
SRCREV_meta = "${AUTOREV}"

# lockdep and might_sleep checking for the locking labs
SRC_URI += "file://labs-debug.cfg"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
LINUX_VERSION ?= "4.19.30"

DEPENDS += "openssl-native util-linux-native"

PV = "${LINUX_VERSION}+git${SRCPV}"

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "1"

COMPATIBLE_MACHINE = "fvp-base"

# meta-arm-bsp appends this 6.x patch; it does not apply to 4.19
SRC_URI:remove:fvp-base = "file://0001-arm64-dts-fvp-Enable-virtio-rng-support.patch"
