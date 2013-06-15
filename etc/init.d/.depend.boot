TARGETS = mountkernfs.sh udev mountdevsubfs.sh hwclock.sh checkroot.sh mountall.sh mountoverflowtmp networking ifupdown mountnfs.sh mountnfs-bootclean.sh urandom live-boot bootmisc.sh ifupdown-clean hostname.sh checkfs.sh mtab.sh stop-bootlogd-single module-init-tools hwclockfirst.sh bootlogd procps mountall-bootclean.sh udev-mtab
INTERACTIVE = udev checkroot.sh checkfs.sh
udev: mountkernfs.sh
mountdevsubfs.sh: mountkernfs.sh udev
hwclock.sh: checkroot.sh bootlogd
checkroot.sh: mountdevsubfs.sh hostname.sh hwclockfirst.sh bootlogd
mountall.sh: checkfs.sh
mountoverflowtmp: mountall-bootclean.sh
networking: mountkernfs.sh mountall.sh mountoverflowtmp ifupdown
ifupdown: ifupdown-clean
mountnfs.sh: mountall.sh mountoverflowtmp networking ifupdown
mountnfs-bootclean.sh: mountall.sh mountoverflowtmp mountnfs.sh
urandom: mountall.sh mountoverflowtmp
live-boot: bootmisc.sh mountall.sh mountoverflowtmp
bootmisc.sh: mountall.sh mountoverflowtmp mountnfs.sh mountnfs-bootclean.sh udev
ifupdown-clean: checkroot.sh
hostname.sh: bootlogd
checkfs.sh: checkroot.sh mtab.sh
mtab.sh: checkroot.sh
stop-bootlogd-single: mountall.sh mountoverflowtmp udev hwclock.sh checkroot.sh networking ifupdown mountnfs.sh mountnfs-bootclean.sh urandom live-boot bootmisc.sh ifupdown-clean mountkernfs.sh hostname.sh checkfs.sh mtab.sh mountdevsubfs.sh module-init-tools hwclockfirst.sh bootlogd procps mountall-bootclean.sh udev-mtab
module-init-tools: checkroot.sh
hwclockfirst.sh: mountdevsubfs.sh bootlogd
bootlogd: mountdevsubfs.sh
procps: mountkernfs.sh mountall.sh mountoverflowtmp udev module-init-tools bootlogd
mountall-bootclean.sh: mountall.sh
udev-mtab: udev mountall.sh mountoverflowtmp
