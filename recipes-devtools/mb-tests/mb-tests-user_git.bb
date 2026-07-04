SUMMARY = "Userspace probe for the mb_tests kernel exercise"
DESCRIPTION = "Prints a process's own view of its address space (.text, .data, \
.bss, heap, stack) so it can be compared against the kernel's mm_struct view \
reported by the kernel_addr module."
HOMEPAGE = "https://github.com/MarekBykowski/linux_kernel_4_19"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

# Same repo as the linux-yocto 4.19 kernel recipe, so the fetch is served
# from the shared DL_DIR git2 mirror at no extra download cost.
SRC_URI = "git://github.com/MarekBykowski/linux_kernel_4_19.git;protocol=https;branch=marek_learning"
SRCREV = "${AUTOREV}"
PV = "1.0+git"

do_compile() {
    oe_runmake -C ${S}/tools/mb_tests
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/tools/mb_tests/user_addr ${D}${bindir}/user_addr
    install -m 0755 ${S}/tools/mb_tests/run.sh ${D}${bindir}/mb-tests-run
}

RRECOMMENDS:${PN} += "kernel-module-kernel-addr"
