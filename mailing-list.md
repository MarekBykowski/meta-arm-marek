# Submitting Patches to meta-arm

## 1. Configure git send-email

```bash
git config --global sendemail.smtpserver smtp.gmail.com
git config --global sendemail.smtpserverport 587
git config --global sendemail.smtpencryption tls
git config --global sendemail.smtpuser marek.bykowski@gmail.com
git config --global sendemail.smtppass "xxxx xxxx xxxx xxxx"
```
## 2. Prepare the patch

```bash
# Last 1 commit
git format-patch -1

# Last N commits, and possiblly cover letter (patch 0000_xxx)
git format-patch -3 --cover-letter
```

This creates `.patch` files in your current directory.

## 3. Check patch style first:**

```bash
# If you have checkpatch.pl, if not copy it from u-boot or kernel
scripts/checkpatch.pl --no-tree `.patch`
```
## 4. Send it

Safe first try

```bash
git send-email --to=marek.bykowski@gmail.com --cc=marek.bykowski@gmail.com `.patch`
```

Real send

```bash
git send-email --to=meta-arm@lists.yoctoproject.org `.patch`
```

## 5. Thread it

First, find the Message-ID of your original patch, it's in the email headers.
On Gmail: open the email -> three dots -> Show original -> look for:

> Message-ID: <CABcd1234xyz@mail.gmail.com>

```bash
git send-email \
  --to=meta-arm@lists.yoctoproject.org \
  --in-reply-to="<CABcd1234xyz@mail.gmail.com>" \
  `.patch`
```

## Notes

- The mailing list only accepts mail from subscribers — subscribe at
  https://lists.yoctoproject.org/g/meta-arm before sending
- Patches must be submitted against the `master` branch
- For backporting to a release branch (e.g. whinlatter), add the branch
  name in the subject: `[whinlatter PATCH]`
- Automatic backporting happens if you add `Fixes: <SHA>` to the commit
  message — see https://www.kernel.org/doc/html/latest/process/submitting-patches.html
