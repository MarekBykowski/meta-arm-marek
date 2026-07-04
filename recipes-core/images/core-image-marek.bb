require recipes-core/images/core-image-minimal.bb

SUMMARY = "core-image-minimal plus Marek's kernel-exercise tooling"

IMAGE_INSTALL += "mb-tests-user kernel-modules"
