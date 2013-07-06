TARGETS = mountkernfs.sh udev mountdevsubfs.sh networking mountall.sh mountoverflowtmp ifupdown mountnfs.sh mountnfs-bootclean.sh ifupdown-clean hwclock.sh checkroot.sh live-boot bootmisc.sh urandom hostname.sh hwclockfirst.sh bootlogd mountall-bootclean.sh udev-mtab procps checkfs.sh stop-bootlogd-single mtab.sh module-init-tools
INTERACTIVE = udev checkroot.sh checkfs.sh
udev: mountkernfs.sh
mountdevsubfs.sh: mountkernfs.sh udev
networking: mountkernfs.sh mountall.sh mountoverflowtmp ifupdown
mountall.sh: checkfs.sh
mountoverflowtmp: mountall-bootclean.sh
ifupdown: ifupdown-clean
mountnfs.sh: mountall.sh mountoverflowtmp networking ifupdown
mountnfs-bootclean.sh: mountall.sh mountoverflowtmp mountnfs.sh
ifupdown-clean: checkroot.sh
hwclock.sh: checkroot.sh bootlogd
checkroot.sh: mountdevsubfs.sh hostname.sh hwclockfirst.sh bootlogd
live-boot: bootmisc.sh mountall.sh mountoverflowtmp
bootmisc.sh: mountall.sh mountoverflowtmp mountnfs.sh mountnfs-bootclean.sh udev
urandom: mountall.sh mountoverflowtmp
hostname.sh: bootlogd
hwclockfirst.sh: bootlogd mountdevsubfs.sh
bootlogd: mountdevsubfs.sh
mountall-bootclean.sh: mountall.sh
udev-mtab: udev mountall.sh mountoverflowtmp
procps: bootlogd mountkernfs.sh mountall.sh mountoverflowtmp udev module-init-tools
checkfs.sh: checkroot.sh mtab.sh
stop-bootlogd-single: mountall.sh mountoverflowtmp udev networking mountkernfs.sh ifupdown mountnfs.sh mountnfs-bootclean.sh ifupdown-clean hwclock.sh checkroot.sh live-boot bootmisc.sh urandom hostname.sh mountdevsubfs.sh hwclockfirst.sh bootlogd mountall-bootclean.sh udev-mtab procps checkfs.sh mtab.sh module-init-tools
mtab.sh: checkroot.sh
module-init-tools: checkroot.sh
