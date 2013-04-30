TARGETS = mountkernfs.sh udev mountall.sh mountoverflowtmp mountnfs.sh mountnfs-bootclean.sh urandom hwclock.sh checkroot.sh live-boot bootmisc.sh hostname.sh checkfs.sh mtab.sh mountdevsubfs.sh module-init-tools hwclockfirst.sh bootlogd stop-bootlogd-single mountall-bootclean.sh udev-mtab
INTERACTIVE = udev checkroot.sh checkfs.sh
udev: mountkernfs.sh
mountall.sh: checkfs.sh
mountoverflowtmp: mountall-bootclean.sh
mountnfs.sh: mountall.sh mountoverflowtmp
mountnfs-bootclean.sh: mountall.sh mountoverflowtmp mountnfs.sh
urandom: mountall.sh mountoverflowtmp
hwclock.sh: checkroot.sh bootlogd
checkroot.sh: mountdevsubfs.sh hostname.sh hwclockfirst.sh bootlogd
live-boot: bootmisc.sh mountall.sh mountoverflowtmp
bootmisc.sh: mountall.sh mountoverflowtmp mountnfs.sh mountnfs-bootclean.sh udev
hostname.sh: bootlogd
checkfs.sh: checkroot.sh mtab.sh
mtab.sh: checkroot.sh
mountdevsubfs.sh: mountkernfs.sh udev
module-init-tools: checkroot.sh
hwclockfirst.sh: mountdevsubfs.sh bootlogd
bootlogd: mountdevsubfs.sh
stop-bootlogd-single: mountall.sh mountoverflowtmp udev mountnfs.sh mountnfs-bootclean.sh urandom hwclock.sh checkroot.sh live-boot bootmisc.sh hostname.sh checkfs.sh mtab.sh mountdevsubfs.sh mountkernfs.sh module-init-tools hwclockfirst.sh bootlogd mountall-bootclean.sh udev-mtab
mountall-bootclean.sh: mountall.sh
udev-mtab: udev mountall.sh mountoverflowtmp
