from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC
import os
import base64

password = os.urandom(16)  # Random password (salt)
kdf = PBKDF2HMAC(
    algorithm=hashes.SHA256(),
    length=32,
    salt=os.urandom(16),
    iterations=100000,
)
secret_key = base64.urlsafe_b64encode(kdf.derive(password)).decode('utf-8')
print("Secret Key:", secret_key)
