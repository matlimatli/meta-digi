# Copyright 2017-2019 NXP

DEPENDS = "zlib openssl"

SRCBRANCH = "imx_5.4.3_2.0.0"
IMX_MKIMAGE_SRC ?= "git://source.codeaurora.org/external/imx/imx-mkimage.git;protocol=https"
SRC_URI = "${IMX_MKIMAGE_SRC};branch=${SRCBRANCH}"
SRCREV = "0fcc82965c695f4754b87ae09b1ec79c0ce6c3b2"
S = "${WORKDIR}/git"

BOOT_TOOLS = "imx-boot-tools"
SYSROOT_DIRS += "/boot"
