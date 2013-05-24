TARGETS = mountkernfs.sh udev mountdevsubfs.sh mountall.sh mountoverflowtmp mountnfs.sh mountnfs-bootclean.sh hwclock.sh urandom live-boot bootmisc.sh checkroot.sh hostname.sh checkfs.sh mtab.sh module-init-tools hwclockfirst.sh bootlogd procps stop-bootlogd-single mountall-bootclean.sh udev-mtab pppd-dns
INTERACTIVE = udev checkroot.sh checkfs.sh
udev: mountkernfs.sh
mountdevsubfs.sh: mountkernfs.sh udev
mountall.sh: checkfs.sh
mountoverflowtmp: mountall-bootclean.sh
mountnfs.sh: mountall.sh mountoverflowtmp
mountnfs-bootclean.sh: mountall.sh mountoverflowtmp mountnfs.sh
hwclock.sh: checkroot.sh bootlogd
urandom: mountall.sh mountoverflowtmp
live-boot: bootmisc.sh mountall.sh mountoverflowtmp
bootmisc.sh: mountall.sh mountoverflowtmp mountnfs.sh mountnfs-bootclean.sh udev
checkroot.sh: mountdevsubfs.sh hostname.sh hwclockfirst.sh bootlogd
hostname.sh: bootlogd
checkfs.sh: checkroot.sh mtab.sh
mtab.sh: checkroot.sh
module-init-tools: checkroot.sh
hwclockfirst.sh: mountdevsubfs.sh bootlogd
bootlogd: mountdevsubfs.sh
procps: mountkernfs.sh mountall.sh mountoverflowtmp udev module-init-tools bootlogd
stop-bootlogd-single: mountall.sh mountoverflowtmp udev mountnfs.sh mountnfs-bootclean.sh hwclock.sh urandom live-boot bootmisc.sh checkroot.sh hostname.sh checkfs.sh mtab.sh mountdevsubfs.sh mountkernfs.sh module-init-tools hwclockfirst.sh bootlogd procps mountall-bootclean.sh udev-mtab pppd-dns
mountall-bootclean.sh: mountall.sh
udev-mtab: udev mountall.sh mountoverflowtmp
pppd-dns: mountall.sh mountoverflowtmp
