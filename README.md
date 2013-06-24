seed
====

The Limeroot core

--NOTE ABOUT FILE PERMISSIONS:--------

1 - After clonning seed please download git-cache-meta:https://gist.github.com/andris9/1978266, make it executable and move 
it to /usr/sbin/, then execute git-cache-meta --apply from within the seed dir, if you make changes to seed and want to 
push it, please run git-cache-meta --store from within the seed dir, this is necesary in order to keep the aproppiate 
file permissions BUT FIRST RUN git-cache-meta --apply.

2- After doing git-cache-meta --apply execute sudo chown root.root *

3- Execute ./no_root_owner

-- END NOTE ----------

Limeroot is based on Debian 6 squeeze using a custom 3.3.6 kernel; this is the base system, you can clone it to chroot in
it to compile stuff for Limeroot, You'll need to install gcc, automake, etc... in it using apt-get or aptitude in order to 
compile anything for Limeroot.

Have fun ;)
