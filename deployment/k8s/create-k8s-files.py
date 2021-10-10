#!/usr/bin/env python3

import click
import os
from jinja2 import Template


def write_deployment_def(template, output, name, version):
    print(f"Creating deployment definition name={name}, version={version}")
    with(open(template, 'rt')) as f:
        template = Template(f.read())
        with(open(output, 'wt')) as out:
            out.write(template.render(name=name, version=version))
        print(f"Wrote {os.path.abspath(output)}")


@click.command()
@click.option('--version', default='latest', help='Docker image')
def cli(version):
    write_deployment_def('deployment-template.yaml', f"deployment-{version}.yaml", "spring-boot-scala-example", version)


if __name__ == '__main__':
    cli()
