apt-get -u --reinstall --fix-missing install $(dpkg -S LC_MESSAGES | cut -d: -f1 | tr ', ' '
' | sort -u)
