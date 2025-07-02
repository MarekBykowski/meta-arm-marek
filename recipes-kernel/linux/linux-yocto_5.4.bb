FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}_${LINUX_VERSION}:"

KBRANCH ?= "v5.4/standard/base"
# mb: our breanch is extender
#KBRANCH = "extender"

require recipes-kernel/linux/linux-yocto_5.4.inc

# board specific branches
KBRANCH_qemuarm  ?= "v5.4/standard/arm-versatile-926ejs"
KBRANCH_qemuarm64 ?= "v5.4/standard/qemuarm64"
KBRANCH_qemumips ?= "v5.4/standard/mti-malta32"
KBRANCH_qemuppc  ?= "v5.4/standard/qemuppc"
KBRANCH_qemuriscv64  ?= "v5.4/standard/base"
KBRANCH_qemux86  ?= "v5.4/standard/base"
KBRANCH_qemux86-64 ?= "v5.4/standard/base"
KBRANCH_qemumips64 ?= "v5.4/standard/mti-malta64"

SRCREV_machine_qemuarm ?= "b3ee7c62bf5a5ce3c7e30aff6c3dd9f70a847a28"
SRCREV_machine_qemuarm64 ?= "bf6581eba15cb43af60fda7053edaf66990c18ac"
SRCREV_machine_qemumips ?= "05580fff716df568dc3f737b288e0e514a908572"
SRCREV_machine_qemuppc ?= "0a016b0775980f67d686e47cc8637adec46856dc"
SRCREV_machine_qemuriscv64 ?= "e2020dbe2ccaef50d7e8f37a5bf08c68a006a064"
SRCREV_machine_qemux86 ?= "e2020dbe2ccaef50d7e8f37a5bf08c68a006a064"
SRCREV_machine_qemux86-64 ?= "e2020dbe2ccaef50d7e8f37a5bf08c68a006a064"
SRCREV_machine_qemumips64 ?= "68f35eeca08d2a681495fd3a7b823ac34d9a97bc"
SRCREV_machine ?= "e2020dbe2ccaef50d7e8f37a5bf08c68a006a064"
# mb: src rev for extender branch
#SRCREV_machine = "92bafbe11ed1b70453d5725c15bdf488f4428180"
# meta remains the same
SRCREV_meta ?= "e8c675c7e11fbd96cd812dfb9f4f6fb6f92b6abb"

# remap qemuarm to qemuarma15 for the 5.4 kernel
# KMACHINE_qemuarm ?= "qemuarma15"

# mb:
#SRC_URI = "git://github.com/MarekBykowski/linux-yocto.git;name=machine;branch=${KBRANCH};protocol=https \
#           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-5.4;destsuffix=${KMETA}"
SRC_URI = "git://git.yoctoproject.org/linux-yocto.git;name=machine;branch=${KBRANCH}; \
           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-5.4;destsuffix=${KMETA}"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
LINUX_VERSION ?= "5.4.178"
# mb: our Linux version is 5.4.104 
#LINUX_VERSION ?= "5.4.104"

DEPENDS += "${@bb.utils.contains('ARCH', 'x86', 'elfutils-native', '', d)}"
DEPENDS += "openssl-native util-linux-native"

PV = "${LINUX_VERSION}+git${SRCPV}"

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "1"

KERNEL_DEVICETREE_qemuarmv5 = "versatile-pb.dtb"

COMPATIBLE_MACHINE = "qemuarm|qemuarmv5|qemuarm64|qemux86|qemuppc|qemumips|qemumips64|qemux86-64|qemuriscv64"

# Functionality flags
KERNEL_EXTRA_FEATURES ?= "features/netfilter/netfilter.scc"
KERNEL_FEATURES:append = " ${KERNEL_EXTRA_FEATURES}"
KERNEL_FEATURES:append_qemuall=" cfg/virtio.scc features/drm-bochs/drm-bochs.scc"
KERNEL_FEATURES:append_qemux86=" cfg/sound.scc cfg/paravirt_kvm.scc"
KERNEL_FEATURES:append_qemux86-64=" cfg/sound.scc cfg/paravirt_kvm.scc"
KERNEL_FEATURES:append = " ${@bb.utils.contains("TUNE_FEATURES", "mx32", " cfg/x32.scc", "", d)}"
KERNEL_FEATURES:append = " ${@bb.utils.contains("DISTRO_FEATURES", "ptest", " features/scsi/scsi-debug.scc", "", d)}"
KERNEL_FEATURES:append = " ${@bb.utils.contains("DISTRO_FEATURES", "ptest", " features/gpio/mockup.scc", "", d)}"


SRC_URI:remove:fvp-base = "file://0001-arm64-dts-fvp-Enable-virtio-rng-support.patch"

#SRC_URI:append:fvp-base = " \
#        file://0001-vdso-disable-vdso.patch \
#        "
