# Copyright (C) 2016-2020, Digi International Inc.

DESCRIPTION = "Recovery initramfs image"
LICENSE = "MIT"

PACKAGE_INSTALL = " \
    busybox \
    ${@bb.utils.contains('STORAGE_MEDIA', 'mmc', 'e2fsprogs-mke2fs', '', d)} \
    ${@bb.utils.contains('STORAGE_MEDIA', 'mtd', 'mtd-utils-ubifs', '', d)} \
    psplash \
    recovery-initramfs \
    swupdate \
    trustfence-tool \
    u-boot-fw-utils \
    wipe \
"

# Do not pollute the initrd image with rootfs features
IMAGE_FEATURES = ""
IMAGE_LINGUAS = ""

python() {
    d.setVar('IMAGE_FSTYPES', 'cpio.gz.u-boot.tf')
}

inherit core-image image_types

IMAGE_ROOTFS_SIZE = "8192"

# Remove some packages added via recommendations
BAD_RECOMMENDATIONS += " \
    openssl-conf \
"

export IMAGE_BASENAME = "dey-image-recovery-initramfs"
