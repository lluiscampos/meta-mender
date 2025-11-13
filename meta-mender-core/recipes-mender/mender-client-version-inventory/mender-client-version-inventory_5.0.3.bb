DESCRIPTION = "Mender Client version inventory script"
HOMEPAGE = "https://mender.io"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = " \
    file://mender-inventory-client-version;subdir=${PN}-${PV} \
"

RCONFLICTS:${PN} = "\
    mender-update (< 5.0.3) mender-update (> 5.0.3) \
    mender-auth (< 5.0.3) mender-auth (> 5.0.3) \
    "

#################################################################################
#  python() {
#      import json
#
#      json_file = d.getVar('FILE_DIRNAME') + '/files/versions.json'
#      with open(json_file, 'r') as f:
#          versions = json.load(f)
#
#      mender_version = versions.get('mender', '')
#      if mender_version:
#          rconflicts = f"mender (< {mender_version}) mender (> {mender_version})"
#          d.setVar('RCONFLICTS:${PN}', rconflicts)

#################################################################################

FILES:${PN}:append:mender-update-install = " \
    ${datadir}/mender/inventory/mender-inventory-client-version \
"

do_install() {
    install -d -m 755 ${D}${datadir}/mender/inventory/
    cp mender-inventory-client-version ${D}${datadir}/mender/inventory/mender-inventory-client-version
}
