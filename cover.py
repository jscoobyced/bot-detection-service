import xml.etree.ElementTree as ET
import anybadge

root = ET.parse('build/reports/kover/xml/report.xml').getroot()
missed = 1
covered = 0
percent_line = 0.0

for coverage in root.findall('counter'):
    type = coverage.get('type')
    if type == "LINE":
        missed = float(coverage.get('missed'))
        covered = float(coverage.get('covered'))
percent_line = 100 * covered / (covered + missed)

percent_line_str = "{:.{}f}%".format(percent_line, 1)
print("Coverage: %s" % percent_line_str)
thresholds = {80: 'red',
              85: 'yellow',
              100: 'green'}

badge = anybadge.Badge('coverage', percent_line_str, thresholds=thresholds)

badge.write_badge('images/coverage.svg', overwrite=True)