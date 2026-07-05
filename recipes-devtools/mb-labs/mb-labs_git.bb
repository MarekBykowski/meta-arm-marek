SUMMARY = "Runner for Marek's mb_labs kernel exercises"
DESCRIPTION = "Installs mb-labs-run.sh, which loads and unloads each mb_labs \
kernel module in turn, prints its dmesg output, and finishes with the vma \
lab runner."
HOMEPAGE = "https://github.com/MarekBykowski/linux_kernel_4_19"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

# Same repo as the linux-yocto 4.19 kernel recipe, so the fetch is served
# from the shared DL_DIR git2 mirror at no extra download cost.
SRC_URI = "git://github.com/MarekBykowski/linux_kernel_4_19.git;protocol=https;branch=marek_learning"
SRCREV = "${AUTOREV}"
PV = "1.0+git"

LAB_DIR = "${S}/drivers/misc/mb_labs"

# nothing to build, only a script to install; without these bitbake's
# default do_compile would oe_runmake the kernel's top-level Makefile
do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${LAB_DIR}/labs-run.sh ${D}${bindir}/labs-run.sh
}

RDEPENDS:${PN} += "vma-lab mmap-lab"
RRECOMMENDS:${PN} += " \
    kernel-module-procfs-lab \
    kernel-module-completion-lab \
    kernel-module-waitqueue-lab \
    kernel-module-workqueue-lab \
    kernel-module-list-lab \
    kernel-module-radix-tree-lab \
    kernel-module-rcu-lab \
    kernel-module-locking-lab \
    kernel-module-lockdep-lab \
    kernel-module-atomics-lab \
    kernel-module-ptwalk-lab \
    kernel-module-kprobe-lab \
    kernel-module-mmap-lab \
    kernel-module-seqlock-lab \
    kernel-module-sysreg-lab \
    kernel-module-ipi-lab \
    kernel-module-context-lab \
    kernel-module-current-lab \
    kernel-module-irqthread-lab \
    kernel-module-hrtimer-lab \
    kernel-module-pacing-lab \
"
