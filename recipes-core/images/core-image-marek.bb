require recipes-core/images/core-image-minimal.bb

SUMMARY = "core-image-minimal plus Marek's kernel-exercise tooling"

IMAGE_INSTALL += "mb-vma-lab kernel-modules"

IMAGE_FEATURES += "ssh-server-dropbear allow-empty-password allow-root-login"
